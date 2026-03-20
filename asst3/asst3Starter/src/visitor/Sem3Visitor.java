package visitor;

import errorMsg.*;
import java.lang.reflect.Field;
import java.util.*;
import syntaxtree.*;
// The purpose of this class is to:
// - link each variable reference to its corresponding VarDecl
//    (via its 'link' field)
//   - undefined variable names are reported
// - link each type reference to its corresponding ClassDecl
//   - undefined type names are reported
// - link each Break expression to its enclosing While or Case statement
//   - a break that is not inside any while loop or case is reported
// - report conflicting local variable names (including formal parameter names)
// - ensure that no instance variable has the name 'length'
public class Sem3Visitor extends Visitor
{
    // current class we're visiting
    ClassDecl currentClass;

    // environment for names of classes
    HashMap<String, ClassDecl> classEnv;

    // environment for names of variables
    HashMap<String, VarDecl> localEnv;

    // set of initialized variables
    HashSet<String> init;

    // set of unused classes
    HashSet<String> unusedClasses;

    // set of unused local variables
    // We use a hashmap so we can store the position where we found it for the error message.
    HashMap<String,Integer> unusedLocals;

    // stack of while/switch
    Stack<BreakTarget> breakTargetStack;

    //error message object
    ErrorMsg errorMsg;

    // constructor
    public Sem3Visitor(HashMap<String,ClassDecl> env, ErrorMsg e)
    {
        errorMsg         = e;
        currentClass     = null;
        classEnv         = env;
        localEnv         = new HashMap<String,VarDecl>();
        breakTargetStack = new Stack<BreakTarget>();
        init             = new HashSet<String>();
    }

    @Override
    public Object visit(Program p){
        p.predefinedDecls.accept(this);
        p.classDecls.accept(this);
        p.mainStmt.accept(this);
        return null;

    }

    @Override
    public Object visit(ClassDecl c) {
        currentClass = c;
        c.decls.accept(this);
        currentClass = c;
        return null;
    }

    // @Override
    // public Object visit(MethodDecl m) {
    //     localEnv.clear();
    //     localEnv.putAll(currentClass.fieldEnv);
    //     m.params.accept(this);
    //     m.stmts.accept(this);
    //     return null;
    // }

    // @Override
    // public Object visit(MethodDecl m) {
    //     HashMap<String, VarDecl> savedEnv = new HashMap<>(localEnv);
    //     init = new HashSet<String>();
    //     m.params.accept(this);
    //     m.stmts.accept(this);
    //     localEnv = savedEnv;
    //     return null;
    // }

    @Override
    public Object visit(MethodDeclVoid m) {
        HashMap<String, VarDecl> savedEnv = new HashMap<>(localEnv);
        init = new HashSet<String>();
        m.params.accept(this);
        m.stmts.accept(this);
        localEnv = savedEnv;
        return null;
    }

    @Override
    public Object visit(MethodDeclNonVoid m) {
        HashMap<String, VarDecl> savedEnv = new HashMap<>(localEnv);
        init = new HashSet<String>();
        m.params.accept(this);
        m.stmts.accept(this);
        m.rtnExp.accept(this);
        localEnv = savedEnv;
        return null;
    }

    @Override
    public Object visit(NewObject n) {
        n.objType.accept(this);
        return null;
    }

    @Override
    public Object visit(LocalVarDecl v) {
        v.type.accept(this);
        if (localEnv.containsKey(v.name)) {
            errorMsg.error(v.pos, CompError.DuplicateVariable(v.name));
        } else {
            localEnv.put(v.name, v);
            v.initExp.accept(this);
            
            
            init.add(v.name);
        }
        return null;   
    }

    @Override
    public Object visit(FieldAccess f) {
        f.exp.accept(this);
        return null;
    }

    @Override
    public Object visit(FieldDecl f) {
        if(f.name.equals("length")) {
            errorMsg.error(f.pos, CompError.IllegalLength());
        }
        return null;
    }

    @Override
    public Object visit(Cast c) {
        c.castType.accept(this);
        c.exp.accept(this);
        return null;
    }

    @Override
    public Object visit(InstanceOf i) {
        i.exp.accept(this);
        i.type.accept(this);
        return null;
    }

    
    @Override
    public Object visit(IDType i){
        ClassDecl classD = classEnv.get(i.name);
        if(classD == null){
            errorMsg.error(i.pos, CompError.UndefinedClass(i.name));
        }
        else{
            i.link = classD;
        }
        return null;
    }

    @Override
    public Object visit(IDExp e) {
        if (localEnv.containsKey(e.name)) {
            if (!init.contains(e.name)) {
                errorMsg.error(e.pos, CompError.UninitializedVariable(e.name));
            }
            e.link = localEnv.get(e.name);
        } else if (currentClass != null && currentClass.fieldEnv.containsKey(e.name)){
            e.link = currentClass.fieldEnv.get(e.name);
        } else if (currentClass != null) {
            FieldDecl sup = superRecurseIDExp(currentClass, e.name);
            if (sup != null) {
                e.link = sup;
            } else {
                errorMsg.error(e.pos, CompError.UndefinedVariable(e.name));
            }
        } else {
            errorMsg.error(e.pos, CompError.UndefinedVariable(e.name));
        }
        return null;
    }

    private FieldDecl superRecurseIDExp(ClassDecl c, String name) {
        if (c == null) {
            return null;
        }
        if (c.fieldEnv.containsKey(name)) {
            return c.fieldEnv.get(name);
        }
        return superRecurseIDExp(c.superLink, name);
    }

    @Override
    public Object visit(Switch n) {
        n.exp.accept(this);
        breakTargetStack.push(n);
        HashMap<String, VarDecl> savedEnv = new HashMap<>(localEnv);
        HashSet<String> savedInit = new HashSet<>(init);
        
        for (int i = 0; i < n.stmts.size(); i++) {
            Stmt s = n.stmts.get(i);
            s.accept(this);
            if (s instanceof Break) {
                localEnv = new HashMap<>(savedEnv);
                init = new HashSet<>(savedInit);
            }
        }
        breakTargetStack.pop();
        localEnv = savedEnv;
        init = savedInit;
        return null;
    }

    @Override
    public Object visit(Case c) {
        c.exp.accept(this);
        return null;
    }

    @Override
    public Object visit(Default d) {
        return null;
    }

    @Override
    public Object visit(Break b) {
        if (breakTargetStack.isEmpty()) {
            errorMsg.error(b.pos, CompError.TopLevelBreak());
        } else {
            b.breakLink = breakTargetStack.peek();
        }
        return null;
    }

    @Override
    public Object visit(While w) {
        HashMap<String, VarDecl> savedEnv = new HashMap<>(localEnv);
        HashSet<String> savedInit = new HashSet<>(init);
        w.exp.accept(this);
        breakTargetStack.push(w);
        w.body.accept(this);
        breakTargetStack.pop();
        localEnv = savedEnv;
        init = savedInit;
        return null;
    }

    @Override
    public Object visit(ParamDecl p) {
        p.type.accept(this);

        if (localEnv.containsKey(p.name)) {
            errorMsg.error(p.pos, CompError.DuplicateVariable(p.name));
        } else {
            localEnv.put(p.name, p);
            init.add(p.name);
        }
        return null;
    }

    @Override
    public Object visit(Block n){
        HashMap<String, VarDecl> savedEnv = new HashMap<>(localEnv);
        HashSet<String> savedInit = new HashSet<>(init);
        n.stmts.accept(this);
        localEnv = savedEnv;
        init = savedInit;
        return null;
    }

    @Override
    public Object visit(If n) {
        HashMap<String, VarDecl> savedEnv = new HashMap<>(localEnv);
        HashSet<String> savedInit = new HashSet<>(init);
        n.exp.accept(this);
        n.trueStmt.accept(this);
        localEnv = savedEnv;
        init = savedInit;
        if (n.falseStmt != null) {
            n.falseStmt.accept(this);
            localEnv = savedEnv;
            init = savedInit;
        }
        
        return null;
}


}
