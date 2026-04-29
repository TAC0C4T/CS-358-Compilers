package visitor;

import errorMsg.*;
import java.io.*;
import syntaxtree.*;

public class CG3Visitor extends Visitor
{
    // The purpose here is to generate assembly for each Node
    // in the AST.

    // IO stream to which we will emit code
    CodeStream code;

    // current stack height
    int stack;

    public CG3Visitor(ErrorMsg e, PrintStream out)
    {
        code = new CodeStream(out, e);
        code.setVisitor3(this);
        stack = 0;
    }

    public void fakeMainStmt()
    {
        code.emit("  li $s6, 1");
        code.emit("  li $s7, 0");
        code.emit("  jal newObject");
        code.emit("  la $t0, CLASS_Main"); // put Main object on the stack
        code.emit("  sw $t0, -12($s7)");
        code.emit("  addu $sp,$sp,4");
        code.emit("  move $s2, $s7");
        code.emit("  jal mth_main_Main");
    }

    @Override
    public Object visit(Program n)
    {
        code.emit(".text");
        code.emit(".globl main");
        code.emit("main:");
        code.emit("  jal vm_init");

        //Put code for mainStmt here:
        //For now, I'll just make code that calls Main_main
        //but you'll need to replace this.
        //fakeMainStmt();
        n.mainStmt.accept(this);
        //exit the program
        code.emit("  li $v0, 10");
        code.emit("  syscall");

        // This is a fake main method until you get MethodDeclVoid working.
        // When that's working you should remove these two lines.
//        code.emit("mth_main_Main:");
//        code.emit("  jr $ra");

        // emit code for all the methods in all the class declarations
        n.classDecls.accept(this);

        // flush the output and return
        code.flush();
        return null;
    }

  @Override
  public Object visit(ClassDecl n)
  {
    n.decls.accept(this);
    return null;
  }

  @Override
  public Object visit(StmtList s) {
    int startstack = stack;
    s.accept(this);
    pop(stack-startstack);
    return null;
  }

  @Override
  public Object visit(Stmt s) {
    s.accept(this);
    return null;
  }



  

  @Override
  public Object visit(Exp e) {
    e.accept(this);
    return null;
  }

  @Override
  public Object visit(MethodDeclVoid m) {
    code.emit(".globl mth_" + m.name + "_" + m.classDecl.name);
    code.emit("mth_" + m.name + "_" + m.classDecl.name + ":");
    push("$ra");
    int savedStack = stack;
    m.stmts.accept(this);
    pop(savedStack - stack);
    pop("$ra");
    code.emit("  jr $ra");
    return null;
  }

  @Override
  public Object visit(MethodDeclNonVoid m) {
    code.emit(".globl mth_" + m.name + "_" + m.classDecl.name);
    code.emit("mth_" + m.name + "_" + m.classDecl.name + ":");
    push("$ra");
    m.stmts.accept(this);
    m.rtnExp.accept(this);
    pop("$t0");
    pop("$ra");
    code.emit("  jr $ra");
    return null;
  }

  @Override
  public Object visit(CallStmt c) {
    c.callExp.accept(this);
    // if (c.callExp.type != null && !c.callExp.type.isVoid()) {
    //   pop(expSize(c.callExp));
    // }
    return null;
  }
  
  @Override
  public Object visit(Call c) {
    System.out.println("stmt" + c.methName);
    push("$s2");
    c.args.accept(this);
    pop("$s2");
    code.emit("  jal mth_" + c.methName + "_" + c.obj.type.name());
    pop("$s2");
    push("$t0");
    return null;
  }

  @Override
  public Object visit(Block n) {
    int startStack = stack;
    for(Stmt s : n.stmts)
    {
        s.accept(this);
    }
    pop(stack - startStack);
    return null;
  }

  
  




  // Ints and Strings
  @Override
  public Object visit(IntLit n) {
    gen(n);
    return null;
  }


  
  

  @Override
  public Object visit(StringLit s) {
    gen(s);
    return null;
  }

  

  //Pseudo Instructions

  public Object gen(StringLit s) {
    StringLit rep = s.uniqueCgRep == null ? s : s.uniqueCgRep;
    code.emit("  la $t0, strLit_" + rep.uniqueId);
    push(s);
    return null;
  }


  public Object push(StringLit s) {
    code.emit("  subu $sp, $sp, 4");
    code.emit("  sw $t0, ($sp)");
    stack++;

    return null;
  }

  public Object push(IntLit n) {
    code.emit("  subu $sp, $sp, 8");
    code.emit("  sw $s5, 4($sp)");
    code.emit("  sw $t0, 0($sp)");
    stack++;
    return null;
  }

  public Object push(String s) {
    code.emit("  subu $sp, $sp, 4");
    code.emit("  sw " + s + ", ($sp)");
    stack++;

    return null;
  }
  
  public Object push(int n) {
    code.emit("  subu $sp, $sp, 8");
    code.emit("  sw $s5, 4($sp)");
    code.emit("  li $t0, " + n);
    code.emit("  sw $t0, 0($sp)");
    stack++;
    return null;
  }

  public Object pop(StringLit n) {
    code.emit("  lw $t0, ($sp)");
    code.emit("  addu $sp, $sp, 4");
    stack--;

    return null;
  }

  public Object pop(int size) {
    code.emit("addu $sp, $sp, " + size);
    stack--;
    return null;
  }

  public Object pop(IntLit n) {
    code.emit("  lw $t0, ($sp)");
    code.emit("  addu $sp, $sp, 8");
    stack--;

    return null;
  }

  public Object pop(String s) {
    code.emit("  lw " + s + ", ($sp)");
    code.emit("  addu $sp, $sp, 4");
    stack--;

    return null;
  }

  public Object gen(IntLit n) {
    code.emit("  li $t0, " + n.val);
    push(n);
    return null;
  }

  








  // Function calls
  // public Object visit(Call c) {
    
  // }

  @Override
  public Object visit(This n) {
    push("$s2");
    //stack++;
    return null;
  }

  public Object visit(Null n) {
    push("$0");
    //stack++;
    return null;
  }
  
  public Object visit(True t) {
    push(1);
    //stack++;
    return null;
  }

  public Object visit(False f) {
    push("$0");
    //stack++;
    return null;
  }

  public Object visit(Super s) {
    push("$s2");
    //stack++;
    return null;
  }

  public Object visit(FieldAccess f) {
    f.exp.accept(this);
    code.emit("  lw $t0, " + f.varDec.offset + "($t0)");
    push("$t0");
    //stack++;
    return null;
  }

  // public Object visit( v) {
  //   code.emit("  lw $t0, " + v.varDec.offset + "($sp)");
  //   push("$t0");
  //   //stack++;
  //   return null;
  // }

  public Object visit(Plus p) {
    p.left.accept(this);
    p.right.accept(this);
    pop("$t2");
    pop("$t1");
    code.emit("  addu $t0, $t1, $t2");
    push("$t0");
    return null;
  }

  public Object visit(Minus m) {
    m.left.accept(this);
    m.right.accept(this);
    pop("$t2");
    pop("$t1");
    code.emit("  subu $t0, $t1, $t2");
    push("$t0");
    return null;
  }

  public Object visit(Times t) {
    t.left.accept(this);
    t.right.accept(this);
    pop("$t2");
    pop("$t1");
    code.emit("  mul $t0, $t1, $t2");
    push("$t0");
    return null;
  }

  public Object visit(Equals e) {
    e.left.accept(this);
    e.right.accept(this);
    pop("$t2");
    pop("$t1");
    code.emit("  seq $t0, $t1, $t2");
    push("$t0");
    return null;
   
  }

  public Object visit(LessThan l) {
    l.left.accept(this);
    l.right.accept(this);
    pop("$t2");
    pop("$t1");
    code.emit("  slt $t0, $t1, $t2");
    push("$t0");
    return null;
  }

  public Object visit(GreaterThan g) {
    g.left.accept(this);
    g.right.accept(this);
    pop("$t2");
    pop("$t1");
    code.emit("  sgt $t0, $t1, $t2");
    push("$t0");
    return null;
  }

  public Object visit(Divide d) {
    d.left.accept(this);
    d.right.accept(this);
    code.emit("  jal divide");
    return null;
  }



  // @Override
  // public Object visit(Super n) {
  //   return visit(new This(n.pos));
  // }

}