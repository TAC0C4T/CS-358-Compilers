package parse;
import java.util.List;
import errorMsg.*;
import syntaxtree.*;
import wrangLR.runtime.MessageObject;
import wrangLR.runtime.FilePosObject;

public class MJGrammar implements MessageObject, FilePosObject
{

    // constructor
    // @param em error-message object
    public MJGrammar(ErrorMsg em)
    {
        errorMsg = em;
        topObject = null;
    }

    // error message object
    private ErrorMsg errorMsg;

    // object to be returned by the parser
    private Program topObject;

    // These 2 methods are needed by WrangLR
    // DO NOT USE THEM! They will not pass tests
    // We don't need any errors or warnings in this assignment.
    public void warning(int pos, String msg)
    {
        errorMsg.info(pos, msg);
    }

    public void error(int pos, String msg)
    {
        errorMsg.error(pos, msg);
    }

    // method for converting file position to line/char position
    // @param pos the file position
    // @return the string that denotes the file position
    public String filePosString(int pos)
    {
        return errorMsg.lineAndChar(pos);
    }

    // method that registers a newline
    // @param pos the file position of the newline character
    public void registerNewline(int pos)
    {
        errorMsg.newline(pos-1);
    }

    // returns the object produced by the parse
    // @return the top-level object produced by the parser
    public Program parseResult()
    {
        return topObject;
    }

    //===============================================================
    // start symbol
    //===============================================================

    //: <start> ::= ws* <program> =>
    public void topLevel(Program obj)
    {
        topObject = obj;
    }

    //================================================================
    // top-level constructs
    //================================================================

    //: <program> ::= # <class decl>+ =>
    public Program createProgram(int pos, List<ClassDecl> vec)
    {
        return new Program(pos, new ClassDeclList(vec));
    }

    //: <class decl> ::= `class # ID `{ <decl in class>* `} =>
    public ClassDecl createClassDecl(int pos, String name, List<Decl> vec)
    {
        return new ClassDecl(pos, name, "Object", new DeclList(vec));
    }

    //: <decl in class> ::= <method decl> => pass

    //: <method decl> ::= `public `void # ID `( `) `{ <stmt>* `} =>
    public Decl createMethodDeclVoid(int pos, String name, List<Stmt> stmts)
    {
        return new MethodDeclVoid(pos, name, new VarDeclList(new VarDeclList()),
                                  new StmtList(stmts));
    }

    //: <type> ::= # `int =>
    public Type intType(int pos)
    {
        return new IntType(pos);
    }
    //: <type> ::= # `boolean =>
    public Type booleanType(int pos)
    {
        return new BoolType(pos);
    }
    //: <type> ::= # ID =>
    public Type idType(int pos, String name)
    {
        return new IDType(pos, name);
    }
    //: <type> ::= # <type> <empty bracket pair> =>
    public Type newArrayType(int pos, Type t, Object dummy)
    {
        return new ArrayType(pos, t);
    }

    //: <empty bracket pair> ::= `[ `] => null

    //================================================================
    // statement-level constructs
    //================================================================

    //: <stmt> ::= <assign> `; => pass

    //: <stmt> ::= # `break `; =>
    public Stmt breakStmt(int pos) {
        return new Break(pos);
    }

    //: <stmt> ::= # ID `++ =>
    public Stmt postIncrement(int pos, String name)
    {
        return new Assign(pos, new IDExp(pos, name), new Plus(pos, new IDExp(pos, name), new IntLit(pos, 1)));
    }

    //: <stmt> ::= # ID `-- =>
    public Stmt postDecrement(int pos, String name)
    {
        return new Assign(pos, new IDExp(pos, name), new Minus(pos, new IDExp(pos, name), new IntLit(pos, 1)));
    }



    //: <stmt> ::= # `++ ID =>
    public Stmt preIncrement(int pos, String name)
    {
        return new Assign(pos, new IDExp(pos, name), new Plus(pos, new IDExp(pos, name), new IntLit(pos, 1)));
    }

    //: <stmt> ::= # `-- ID =>
    public Stmt preDecrement(int pos, String name)
    {
        return new Assign(pos, new IDExp(pos, name), new Minus(pos, new IDExp(pos, name), new IntLit(pos, 1)));
    }
    //: <stmt> ::= # `if `( <expr> `) <stmt> `else <stmt> => 
    public Stmt ifElseStmt(int pos, Exp e, Stmt trueb, Stmt falb) {
        return new If(pos, e, trueb, falb);
    }


    //: <stmt> ::= # `if `( <expr> `) <stmt> !`else =>
    public Stmt ifStmt (int pos, Exp e, Stmt stmnt) {
        return new If(pos, e, stmnt, null);
    }


    //: <stmt> ::= # `{ <stmt>* `} =>
    public Stmt newBlock(int pos, List<Stmt> sl)
    {
        return new Block(pos, new StmtList(sl));
    }
    //: <stmt> ::= <local var decl> `; => pass

    //: <assign> ::= <expr> # `= <expr> =>
    public Stmt assign(Exp lhs, int pos, Exp rhs)
    {
        return new Assign(pos, lhs, rhs);
    }

    //: <local var decl> ::= <type> # ID `= <expr> =>
    public Stmt localVarDecl(Type t, int pos, String name, Exp init)
    {
        return new LocalDeclStmt(pos, new LocalVarDecl(pos, t, name, init));
    }

    //================================================================
    // expressions
    //================================================================

    //: <expr> ::= <expr8> => pass
    public Exp exprToExpr8(Exp e) {return e;}

    // these precedence levels have not been filled in at all, so there
    // are only pass-through productions
    //: <expr8> ::= <expr8> # `|| <expr7> =>
    public Exp newOr(Exp e1, int pos, Exp e2) {
        return new Or(pos, e1, e2);
    }
    //: <expr8> ::= <expr7> => pass
    //: <expr7> ::= <expr7> # `&& <expr6> =>
    public Exp newAnd(Exp e1, int pos, Exp e2) {
        return new And(pos, e1, e2);
    }
    //: <expr7> ::= <expr6> => pass
    //: <expr6> ::= <expr6> # `== <expr5> =>
    public Exp newEqualEqual(Exp e1, int pos, Exp e2) {
        return new Equals(pos, e1, e2);
    }
    //: <expr6> ::= <expr6> # `!= <expr5> =>
    public Exp newNotEquals(Exp e1, int pos, Exp e2) {
        return new Not(pos, new Equals(pos, e1, e2));
    }
    //: <expr6> ::= <expr5> => pass
    //: <expr5> ::= <expr5> # `< <expr4> =>
    public Exp newLessThan(Exp e1, int pos, Exp e2) {
        return new LessThan(pos, e1, e2);
    }
    //: <expr5> ::= <expr5> # `> <expr4> =>
    public Exp newGreaterThan(Exp e1, int pos, Exp e2) {
        return new GreaterThan(pos, e1, e2);
    }
    //: <expr5> ::= <expr5> # `<= <expr4> =>
    public Exp newLessThanEqual(Exp e1, int pos, Exp e2){
        return new Or(pos, new LessThan(pos, e1, e2), new Equals(pos, e1, e2));
    }
    
    //: <expr5> ::= <expr5> # `>= <expr4> =>
    public Exp newGreaterThanEqual(Exp e1, int pos, Exp e2){
        return new Or(pos, new GreaterThan(pos, e1, e2), new Equals(pos, e1, e2));
    }

    //: <expr5> ::= <expr5> # `instanceof <type> =>
    public Exp newInstanceof(Exp e1, int pos, Type e2){
        return new InstanceOf(pos, e1, e2);
    }
    //: <expr5> ::= <expr4> => pass
    // these remaining precedence levels have been filled in to some extent,
    // but most or all of them have need to be expanded

    //: <expr4> ::= <expr4> # `+ <expr3> =>
    public Exp newPlus(Exp e1, int pos, Exp e2)
    {
        return new Plus(pos, e1, e2);
    }
    //: <expr4> ::= <expr4> # `- <expr3> =>
    public Exp newMinus(Exp e1, int pos, Exp e2)
    {
        return new Minus(pos, e1, e2);
    }
    //: <expr4> ::= <expr3> => pass
    //: <expr3> ::= <expr3> # `* <expr2> =>
    public Exp newTimes(Exp e1, int pos, Exp e2)
    {
        return new Times(pos, e1, e2);
    }
    //: <expr3> ::= <expr3> # `/ <expr2> =>
    public Exp newDivide(Exp e1, int pos, Exp e2){
        return new Divide(pos, e1, e2);
    }
    //: <expr3> ::= <expr3> # `% <expr2> =>
    public Exp newMod(Exp e1, int pos, Exp e2){
        return new Remainder(pos, e1, e2);
    }
    //: <expr3> ::= <expr2> => pass

    //: <expr2> ::= <cast expr> => pass

    

    //: <cast expr> ::= # `( <type> `) <cast expr> =>
    public Exp newCast(int pos, Type t, Exp e)
    {
        return new Cast(pos, t, e);
    }
    //: <cast expr> ::= # `( <type> `) <expr1> => Exp newCast(int, Type, Exp)
    //: <expr2> ::= <unary expr> => pass

    //: <unary expr> ::= # `- <unary expr> =>
    public Exp newUnaryMinus(int pos, Exp e)
    {
        return new Minus(pos, new IntLit(pos, 0), e);
    }
    //: <unary expr> ::= # `+ <unary expr> =>
    public Exp newUnaryPlus(int pos, Exp e) {
        return new Plus(pos, new IntLit(pos, 0), e);
    }

    //: <unary expr> ::= # `! <unary expr> =>
    public Exp newNot(int pos, Exp e) {
        return new Not(pos, e);
    }

    //: <unary expr> ::= <expr1> => pass

    //: <expr1> ::= # <expr1> `. ID =>
    public Exp newFieldAccess(int pos, Exp e, String ID) {
        return new FieldAccess(pos, e, ID);
    }

    //: <expr1> ::= # ID  =>
    public Exp newIDExp(int pos, String name)
    {
        return new IDExp(pos, name);
    }

    // <expr1> ::= <callExp> => null
    // <expList> ::= <expr> `( <expListEl>* `) => null
    // <expListEl> ::= `, <expr> => null
    // <callExp> ::= # ID `( <expList> `) =>
    //public CallStmt callExp

    //: <exprs> ::= `, <expr> => pass

    //: <exprList> ::= => null
    //: <exprList> ::= # <expr> <exprs>* =>
    public ExpList newExpList(int pos, Exp e, List<Exp> en) {
        ExpList lst = new ExpList();
        if(e != null) {
            lst.append(e);
        }
        for (Exp temp : en) {
            lst.append(temp);
        }
        return new ExpList(lst);
    }

    //: <callExp> ::= # <expr1> `. ID `( <exprList> `) =>
    public Call newExprCall(int pos, Exp e, String id, ExpList lst){
        if(lst == null) {
            return new Call(pos, e, id, null);
        }
        return new Call(pos, e, id, new ExpList(lst));
    }

    //: <callExp> ::= # `super `. ID `( <exprList> `) =>
    public Call newExperCall(int pos, String id, ExpList lst) {
        if(lst == null) {
            return new Call(pos, new Super(pos), id, null);
        }
        return new Call(pos, new Super(pos), id, new ExpList(lst));
    }

    //: <callExp> ::= # !<expr1> `. ID `( <exprList> `) =>
    public Call newExprSuperCall(int pos, String id, ExpList lst) {
        if(lst == null){
            return new Call(pos, null, id, null);
        }
        return new Call(pos, null, id, new ExpList(lst));
    }

    //: <expr1> ::= <expr1> !<empty bracket pair> # `[ <expr> `] =>
    public Exp newArrayLookup(Exp e1, int pos, Exp e2)
    {
        return new ArrayLookup(pos, e1, e2);
    }
    //: <expr1> ::= # INTLIT =>
    public Exp newIntLit(int pos, int n)
    {
        return new IntLit(pos, n);
    }

    //: <expr1> ::= # `true =>
    public Exp newTrue(int pos) {
        return new True(pos);
    }

    //: <expr1> ::= # `false =>
    public Exp newFalse(int pos) {
        return new False(pos);
    }

    //: <expr1> ::= # `null =>
    public Exp newNull(int pos){
        return new Null(pos);
    }

    //: <expr1> ::= # `this =>
    public Exp newThis(int pos) {
        return new This(pos);
    }


    //================================================================
    // Lexical grammar for filtered language begins here: DO NOT
    // MODIFY ANYTHING BELOW THIS, UNLESS YOU REPLACE IT WITH YOUR
    // ENTIRE LEXICAL GRAMMAR, and set the constant FILTER_GRAMMAR
    // (defined near the top of this file) to false.
    //================================================================

    //: letter ::= {"a".."z" "A".."Z"} => pass
    //: letter128 ::= {225..250 193..218} =>
    public char sub128(char orig)
    {
        return (char)(orig-128);
    }
    //: digit ::= {"0".."9"} => pass
    //: digit128 ::= {176..185} => char sub128(char)
    //: any ::= {0..127} => pass
    //: any128 ::= {128..255} => char sub128(char)
    //: ws ::= " "
    //: ws ::= {10} registerNewline
    //: registerNewline ::= # => void registerNewline(int)
    //: `boolean ::= "#bo" ws*
    //: `class ::= "#cl" ws*
    //: `extends ::= "#ex" ws*
    //: `void ::= "#vo" ws*
    //: `int ::= "#it" ws*
    //: `while ::= "#wh" ws*
    //: `if ::= '#+' ws*
    //: `else ::= "#el" ws*
    //: `for ::= "#fo" ws*
    //: `break ::= "#br" ws*
    //: `this ::= "#th" ws*
    //: `false ::= '#fa' ws*
    //: `true ::= "#tr" ws*
    //: `super ::= "#su" ws*
    //: `null ::= "#nu" ws*
    //: `return ::= "#re" ws*
    //: `instanceof ::= "#in" ws*
    //: `new ::= "#ne" ws*
    //: `case ::= "#ce" ws*
    //: `default ::= "#de" ws*
    //: `do ::= "#-" ws*
    //: `public ::= "#pu" ws*
    //: `switch ::= "#sw" ws*

    //: `! ::=  "!" ws* => void
    //: `!= ::=  "@!" ws* => void
    //: `% ::= "%" ws* => void
    //: `&& ::= "@&" ws* => void
    //: `* ::= "*" ws* => void
    //: `( ::= "(" ws* => void
    //: `) ::= ")" ws* => void
    //: `{ ::= "{" ws* => void
    //: `} ::= "}" ws* => void
    //: `- ::= "-" ws* => void
    //: `+ ::= "+" ws* => void
    //: `= ::= "=" ws* => void
    //: `== ::= "@=" ws* => void
    //: `[ ::= "[" ws* => void
    //: `] ::= "]" ws* => void
    //: `|| ::= "@|" ws* => void
    //: `< ::= "<" ws* => void
    //: `<= ::= "@<" ws* => void
    //: `, ::= "," ws* => void
    //: `> ::= ">"  !'=' ws* => void
    //: `>= ::= "@>" ws* => void
    //: `: ::= ":" ws* => void
    //: `. ::= "." ws* => void
    //: `; ::= ";" ws* => void
    //: `++ ::= "@+" ws* => void
    //: `-- ::= "@-" ws* => void
    //: `/ ::= "/" ws* => void


    //: ID ::= letter128 ws* => text
    //: ID ::= letter idChar* idChar128 ws* => text

    //: INTLIT ::= {"1".."9"} digit* digit128 ws* =>
    public int convertToInt(char c, List<Character> mid, char last)
    {
        return Integer.parseInt(""+c+mid+last);
    }
    //: INTLIT ::= digit128 ws* =>
    public int convertToInt(char c)
    {
        return Integer.parseInt(""+c);
    }
    //: INTLIT ::= "0" hexDigit* hexDigit128 ws* =>
    public int convert16ToInt(char c, List<Character> mid, char last)
    {
        return Integer.parseInt(""+c+mid+last, 16);
    }
    //: STRINGLIT ::= '@"' ws* =>
    public String emptyString(char x, char xx)
    {
        return "";
    }
    //: STRINGLIT ::= '"' any* any128 ws* =>
    public String string(char x, List<Character> mid, char last)
    {
        return ""+mid+last;
    }
    //: CHARLIT ::= "'" any ws* =>
    public int charVal(char x, char val)
    {
        return val;
    }

    //: idChar ::= letter => pass
    //: idChar ::= digit => pass
    //: idChar ::= "_" => pass
    //: idChar128 ::= letter128 => pass
    //: idChar128 ::= digit128 => pass
    //: idChar128 ::= {223} =>
    public char underscore(char x)
    {
        return '_';
    }
    //: hexDigit ::= {"0".."9" "A".."Z" "a".."z"} => pass
    //: hexDigit128 ::= {176..185 225..230 193..198} => char sub128(char)

}
