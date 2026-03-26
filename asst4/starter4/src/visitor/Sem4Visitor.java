package visitor;

import errorMsg.*;
import java.util.*;
import syntaxtree.*;
// The purpose of this class is to do type-checking and related
// actions.  These include:
// - evaluate the type for each expression, 
//   filling in the 'type' link for each
// - ensure that each expression follows MiniJava's type rules (e.g.,
//   that the arguments to '*' are both integer, the argument to
//   '.length' is an array, etc.)
// - ensure that each method-call follows Java's type rules:
//   - there exists a method for the given class (or a superclass)
//     for the receiver's object type
//   - the method has the correct number of parameters
//   - the types of each actual parameter is compatible with that
//     of its corresponding formal parameter
// - ensure that for each instance variable access (e.g., abc.foo),
//   there is an instance variable defined for the given class (or
//   in a superclass
//   - sets the 'varDec' link in the InstVarAccess to refer to the
//     method
// - ensure that the RHS expression in each assignment statement is
//   type-compatible with its corresponding LHS
//   - also checks that the LHS an lvalue
// - ensure that if a method with a given name is defined in both
//   a subclass and a superclass, that they have the same parameters
//   (with identical types) and the same return type
// - ensure that the declared return-type of a method is compatible
//   with its "return" expression
// - ensuring that the type of the control expression for an if- or
//   while-statement is boolean
public class Sem4Visitor extends Visitor
{
    ClassDecl currentClass;
    IDType currentType;
    IDType superType;
    ErrorMsg errorMsg;

    // Constants for types we'll need
    BoolType Bool;
    IntType Int;
    VoidType Void;
    NullType Null;
    ErrorType Error;
    IDType ObjectType;
    IDType StringType;

    HashMap<String,ClassDecl> classEnv;

    public Sem4Visitor(HashMap<String,ClassDecl> env, ErrorMsg e)
    {
        errorMsg = e;
        classEnv = env;
        currentClass = null;

        Bool = new BoolType(-1);
        Int  = new IntType(-1);
        Null = new NullType(-1);
        Void = new VoidType(-1);
        Error = new ErrorType(-1);
        StringType = new IDType(-1, "String");
        ObjectType = new IDType(-1, "Object");
        StringType.link = classEnv.get("String");
        ObjectType.link = classEnv.get("Object");
    }

    @Override
    public Object visit(IntLit i)
    {
        i.type = Int;
        return Int;
    }

    public Object visit(Plus p)
    {
        Type t1 = (Type)p.left.accept(this);
        Type t2 = (Type)p.right.accept(this);
        if(!t1.isInt())
        {
            errorMsg.error(p.pos, CompError.TypeMismatch(t1, Int));
        }
        else if(!t2.isInt())
        {
            errorMsg.error(p.pos, CompError.TypeMismatch(t2, Int));
        }
        p.type = Int;
        return Int;
    }

    public Object visit(Minus m)
    {
        Type t1 = (Type)m.left.accept(this);
        Type t2 = (Type)m.right.accept(this);
        if(t1 == null || !t1.isInt()) {
            errorMsg.error(m.pos, CompError.TypeMismatch(t1, Int));
        }
        else if(t2 == null || !t2.isInt()) {
            errorMsg.error(m.pos, CompError.TypeMismatch(t2, Int));
        }
        m.type = Int;
        return Int;
    }

    public Object visit(Times t)
    {
        Type t1 = (Type)t.left.accept(this);
        Type t2 = (Type)t.right.accept(this);
        if(t1 == null || !t1.isInt()) {
            errorMsg.error(t.pos, CompError.TypeMismatch(t1, Int));
        }
        else if(t2 == null || !t2.isInt()) {
            errorMsg.error(t.pos, CompError.TypeMismatch(t2, Int));
        }
        t.type = Int;
        return Int;
    }

    public Object visit(Divide d) {
        Type t1 = (Type)d.left.accept(this);
        Type t2 = (Type)d.right.accept(this);
        if(t1 == null || !t1.isInt()) {
            errorMsg.error(d.pos, CompError.TypeMismatch(t1, Int));
        }
        else if(t2 == null || !t2.isInt()) {
            errorMsg.error(d.pos, CompError.TypeMismatch(t2, Int));
        }
        d.type = Int;
        return Int;
    }

    public Object visit (Remainder r) {
        Type t1 = (Type)r.left.accept(this);
        Type t2 = (Type)r.right.accept(this);
        if(!t1.isInt()) {
            errorMsg.error(r.pos, CompError.TypeMismatch(t1, Int));
        }
        else if(!t2.isInt()) {
            errorMsg.error(r.pos, CompError.TypeMismatch(t2, Int));
        }
        r.type = Int;
        return Int;
    }

    public Object visit (LessThan l) {
        Type t1 = (Type)l.left.accept(this);
        Type t2 = (Type)l.right.accept(this);
        if(!t1.isInt()) {
            errorMsg.error(l.pos, CompError.TypeMismatch(t1, Int));
        }
        if(!t2.isInt()) {
            errorMsg.error(l.pos, CompError.TypeMismatch(t2, Int));
        }
        l.type = Bool;
        return Bool;
    }

    public Object visit (GreaterThan g) {
        Type t1 = (Type)g.left.accept(this);
        Type t2 = (Type)g.right.accept(this);
        if(!t1.isInt()) {
            errorMsg.error(g.pos, CompError.TypeMismatch(t1, Int));
        }
        if(!t2.isInt()) {
            errorMsg.error(g.pos, CompError.TypeMismatch(t2, Int));
        }
        g.type = Bool;
        return Bool;
    }

    public Object visit(Equals e) {
        Type t1 = (Type)e.left.accept(this);
        Type t2 = (Type)e.right.accept(this);
        if (t1 == null || t2 == null || t1.isError() || t2.isError()) {
            e.type = Bool;
            return Bool;
        }

        if  (t1.isVoid() || t2.isVoid()) {
            e.type = Error;
            return Error;
        }
        
        if (!isCompatible(t1, t2) && !isCompatible(t2, t1)) {
            errorMsg.error(e.pos, CompError.IncompatibleType(t1, t2));
            e.type = Error;
            return Error;
        }
        e.type = Bool;
        return Bool;
    }

    public Object visit (And a) {
        Type t1 = (Type)a.left.accept(this);
        Type t2 = (Type)a.right.accept(this);
        if(!t1.isBoolean()) {
            errorMsg.error(a.pos, CompError.IncompatibleType(t1, Bool));
            a.type = Error;
            return Error;
        }
        else if(!t2.isBoolean()) {
            errorMsg.error(a.pos, CompError.IncompatibleType(t2, Bool));
            a.type = Error;
            return Error;
        }
        a.type = Bool;
        return Bool;
    }

    public Object visit (Or o) {
        Type t1 = (Type)o.left.accept(this);
        Type t2 = (Type)o.right.accept(this);
        if(!t1.isBoolean()) {
            errorMsg.error(o.pos, CompError.IncompatibleType(t1, Bool));
            o.type = Error;
            return Error;
        }
        else if(!t2.isBoolean()) {
            errorMsg.error(o.pos, CompError.IncompatibleType(t2, Bool));
            o.type = Error;
            return Error;
        }
        o.type = Bool;
        return Bool;
    }

    public Object visit(Not n) {
        Type t = (Type)n.exp.accept(this);
        if(!t.isBoolean()) {
            errorMsg.error(n.pos, CompError.TypeMismatch(t, Bool));
            n.type = Error;
            return Error;
        }
        n.type = Bool;
        return Bool;
    }

    @Override
    public Object visit(ClassDecl c) {
        ClassDecl prevClass = currentClass;
        IDType prevCurrentType = currentType;
        IDType prevSuperType = superType;

        currentClass = c;
        currentType = new IDType(c.pos, c.name);
        currentType.link = c;

        if (c.superLink != null) {
            superType = new IDType(c.pos, c.superLink.name);
            superType.link = c.superLink;
        } else {
            superType = null;
        }

        c.decls.accept(this);

        currentClass = prevClass;
        currentType = prevCurrentType;
        superType = prevSuperType;
        return null;
    }

    @Override
    public Object visit(VarDecl v) {
        v.type.accept(this);
        return null;
    }

    @Override
    public Object visit(MethodDeclNonVoid m) {
        m.params.accept(this);
        if (m.superMethod != null) {
            if (m.superMethod instanceof MethodDeclVoid) {
                errorMsg.error(m.pos, CompError.ReturnOverride());
            } else if (m.superMethod instanceof MethodDeclNonVoid) {
                MethodDeclNonVoid sup = (MethodDeclNonVoid) m.superMethod;
                if (!m.rtnType.name().equals(sup.rtnType.name())) {
                    errorMsg.error(m.pos, CompError.ReturnOverride());
                }
                if (m.params.size() != sup.params.size()) {
                    errorMsg.error(m.pos, CompError.NumArgsOverride());
                } else {
                    for (int i = 0; i < m.params.size(); i++) {
                        if (!m.params.get(i).type.name().equals(sup.params.get(i).type.name())) {
                            errorMsg.error(m.pos, CompError.ArgTypeOverride());
                        }
                    }
                }
            }
        }
        m.stmts.accept(this);
        if (m.rtnExp != null) {
            Type rtnType = (Type) m.rtnExp.accept(this);
            if (rtnType == null) {
                rtnType = m.rtnExp.type;
            }
            if (rtnType != null && !rtnType.isError() && !isCompatible(rtnType, m.rtnType)) {
                errorMsg.error(m.rtnExp.pos, CompError.TypeMismatch(rtnType, m.rtnType));
            }
        }
        return null;
    }

    @Override
    public Object visit(MethodDeclVoid m) {
        m.params.accept(this);
        if (m.superMethod != null) {
            if (m.superMethod instanceof MethodDeclVoid) {
                MethodDeclVoid sup = (MethodDeclVoid) m.superMethod;
                if (m.params.size() != sup.params.size()) {
                    errorMsg.error(m.pos, CompError.NumArgsOverride());
                } else {
                    for (int i = 0; i < m.params.size(); i++) {
                        if (!m.params.get(i).type.name().equals(sup.params.get(i).type.name())) {
                            errorMsg.error(m.pos, CompError.ArgTypeOverride());
                        }
                    }
                }
            } else if (m.superMethod instanceof MethodDeclNonVoid) {
                errorMsg.error(m.pos, CompError.ReturnOverride());
            }
        }
        m.stmts.accept(this);
        return null;
    }

    @Override
    public Object visit(ParamDecl p) {
        p.type.accept(this);
        return null;
    }

    @Override
    public Object visit(FieldDecl f) {
        f.type.accept(this);
        return null;
    }

    @Override
    public Object visit(LocalVarDecl v) {
        v.type.accept(this);
        v.initExp.accept(this);
        if (!isCompatible(v.initExp.type, v.type)) {
            errorMsg.error(v.pos, CompError.TypeMismatch(v.initExp.type, v.type));
        }
        return null;
    }

    @Override
    public Object visit(True t) {
        t.type = Bool;
        return Bool;
    }

    @Override
    public Object visit(False f) {
        f.type = Bool;
        return Bool;
    }

    @Override
    public Object visit(Null n) {
        n.type = Null;
        return Null;
    }

    @Override
    public Object visit(Super s) {
        s.type = superType;
        return superType;
    }

    @Override
    public Object visit(This t) {
        t.type = currentType;
        return currentType;
    }

    @Override
    public Object visit(IDExp e) {
        e.type = e.link.type;
        if (e.type == null){
            errorMsg.error(e.pos, CompError.Assignment());
            e.type = Error;
            return Error;
        }
        return e.type;
    }

    @Override
    public Object visit(StringLit s) {
        s.type = StringType;
        return StringType;
    }

    @Override
    public Object visit(ArrayLookup e) {
        Type arrType = (Type)e.arrExp.accept(this);
        Type idxType = (Type)e.idxExp.accept(this);

        if(arrType == null || !arrType.isArray()) {
            errorMsg.error(e.pos, CompError.ArrayType());
            e.type = Error;
            return Error;
        }

        if(idxType == null || !idxType.isInt()) {
            errorMsg.error(e.pos, CompError.TypeMismatch(idxType, Int));
            e.type = Error;
            return Error;
        }

        e.type = ((ArrayType)arrType).baseType;
        return e.type;
    }

    @Override
    public Object visit(ArrayLength a) {
        Type expType = (Type)a.exp.accept(this);
        if (expType == null || !expType.isArray()) {
            errorMsg.error(a.pos, CompError.ArrayType());
            a.type = Error;
            return Error;
        }
        a.type = Int;
        return Int;
    }

    @Override
    public Object visit(FieldAccess e) {
        Type objType = (Type)e.exp.accept(this);

        if (objType == null) {
            errorMsg.error(e.pos, CompError.UndefinedField(e.varName, objType));
            e.type = Error;
            return Error;
        }

        if (objType.isError()) {
            e.type = Error;
            return Error;
        }

        if (!objType.isID()) {
            errorMsg.error(e.pos, CompError.UndefinedField(e.varName, objType));
            e.type = Error;
            return Error;
        }

        ClassDecl cls = ((IDType)objType).link;
        FieldDecl fieldDecl = null;
        for (ClassDecl cur = cls; cur != null && fieldDecl == null; cur = cur.superLink) {
            fieldDecl = cur.fieldEnv.get(e.varName);
        }

        if (fieldDecl == null) {
            errorMsg.error(e.pos, CompError.UndefinedField(e.varName, objType));
            e.type = Error;
            return Error;
        }

        e.varDec = fieldDecl;
        e.type = fieldDecl.type;
        return e.type;
    }

    @Override
    public Object visit(Call c) {
        Type objType = (Type)c.obj.accept(this);
        c.args.accept(this);

        if (objType == null) {
            errorMsg.error(c.pos, CompError.UndefinedMethod(c.methName, objType));
            c.type = Error;
            return Error;
        }

        if (objType.isError()) {
            c.type = Error;
            return Error;
        }

        if (!objType.isID()) {
            errorMsg.error(c.pos, CompError.UndefinedMethod(c.methName, objType));
            c.type = Error;
            return Error;
        }

        if (c.methodLink == null) {
            ClassDecl cls = ((IDType)objType).link;
            for (ClassDecl cur = cls; cur != null && c.methodLink == null; cur = cur.superLink) {
                c.methodLink = cur.methodEnv.get(c.methName);
            }
        }

        if (c.methodLink == null) {
            errorMsg.error(c.pos, CompError.UndefinedMethod(c.methName, objType));
            c.type = Error;
            return Error;
        }

        if (c.args.size() != c.methodLink.params.size()) {
            errorMsg.error(c.pos, CompError.NumArgsOverride());
        } else {
            for (int i = 0; i < c.args.size(); i++) {
                Type argType = c.args.get(i).type;
                Type paramType = c.methodLink.params.get(i).type;
                if (argType != null && !argType.isError() && !isCompatible(argType, paramType)) {
                    errorMsg.error(c.args.get(i).pos, CompError.TypeMismatch(argType, paramType));
                }
            }
        }

        if (c.methodLink instanceof MethodDeclNonVoid) {
            c.type = ((MethodDeclNonVoid)c.methodLink).rtnType;
        } else {
            c.type = Void;
        }
        return c.type;
    }

    @Override
    public Object visit(Cast c) {
        Type objType = (Type)c.exp.accept(this);
        if (objType == null || objType.isError()) {
            c.type = c.castType;
            return c.castType;
        }

        if (!isReferenceType(objType) || !isReferenceType(c.castType)) {
            errorMsg.error(c.pos, CompError.IncompatibleType(objType, c.castType));
        } else if (!isCompatible(objType, c.castType) && !isCompatible(c.castType, objType)) {
            errorMsg.error(c.pos, CompError.TypeMismatch(c.castType, objType));
        }
        c.type = c.castType;
        return c.castType;

    }

    @Override
    public Object visit(InstanceOf i) {
        Type objType = (Type)i.exp.accept(this);
        Type checkType = i.checkType;
        if (objType == null || checkType == null) {
            errorMsg.error(i.pos, CompError.TypeMismatch(objType, checkType));
            i.type = Error;
            return Error;
        }
        if(objType.isError() || checkType.isError()) {
            i.type = Error;
            return Error;
        }

        if (!isReferenceType(objType) || !isReferenceType(checkType)) {
            errorMsg.error(i.pos, CompError.IncompatibleType(objType, checkType));
            i.type = Error;
            return Error;
        }

        if (!objType.isNull() && !isCompatible(objType, checkType) && !isCompatible(checkType, objType)) {
            errorMsg.error(i.pos, CompError.TypeMismatch(checkType, objType));
            i.type = Error;
            return Error;
        }

        i.type = Bool;
        return Bool;
    }

    @Override
    public Object visit(NewArray n) {
        Type objType = n.objType;
        Type sizeType = (Type)n.sizeExp.accept(this);

        if(sizeType == null) {
            n.type = Error;
            return Error;
        }

        if (!sizeType.isInt()) {
            errorMsg.error(n.sizeExp.pos, CompError.TypeMismatch(sizeType, Int));
            n.type = Error;
            return Error;
        }

        if(!sizeType.name().equals(Int.name())) {
            errorMsg.error(n.pos, CompError.TypeMismatch(sizeType, Int));
            n.type = Error;
            return Error;
        }

        if (n.sizeExp instanceof IntLit && ((IntLit)n.sizeExp).val < 0) {
            errorMsg.error(n.pos, CompError.IllegalLength());
            n.type = Error;
            return Error;
        }
        n.type = new ArrayType(n.pos, objType);
        return n.type;

    }


    @Override
    public Object visit(NewObject n) {
        if (n.objType == null || n.objType.link == null) {
            n.type = Error;
            return Error;
        }

        n.type = n.objType;
        return n.type;
    }

    public Object visit(Assign a) {
    Type lhs = (Type)a.lhs.accept(this);
    Type rhs = (Type)a.rhs.accept(this);
    if (lhs == null || lhs.isError()) {
        return null;
    }
    if (rhs == null || rhs.isError()){
        return null;
    } 
    if (!isCompatible(rhs, lhs)) {
        errorMsg.error(a.pos, CompError.TypeMismatch(rhs, lhs));
    }
    return null;
}
    public Object visit(If i) {
        Type condType = (Type) i.exp.accept(this);
        if (condType == null || !condType.isBoolean()) {
            errorMsg.error(i.pos, CompError.TypeMismatch(condType, Bool));
        }
        i.trueStmt.accept(this);
        i.falseStmt.accept(this);
        return null;
    }

    public Object visit(While w) {
        Type condType = (Type) w.exp.accept(this);
        if (condType == null || !condType.isBoolean()) {
            errorMsg.error(w.pos, CompError.TypeMismatch(condType, Bool));
        }
        w.body.accept(this);
        return null;
    }

    boolean isCompatible(Type actual, Type expected) {
        if (actual == null || actual.isError()) return true;
        if (expected == null || expected.isError()) return true;
        if (actual.isNull() && (expected.isID() || expected.isArray())) return true;

        if (actual.isArray() && expected.isID()) {
            IDType expectedId = (IDType)expected;
            if ("Object".equals(expectedId.name) ||
                (expectedId.link != null && "Object".equals(expectedId.link.name))) {
                return true;
            }
        }

        if (actual.isArray() && expected.isArray()) {
            Type actualBase = ((ArrayType)actual).baseType;
            Type expectedBase = ((ArrayType)expected).baseType;

            if (actualBase.isBoolean() || actualBase.isInt() ||
                expectedBase.isBoolean() || expectedBase.isInt()) {
                return actualBase.name().equals(expectedBase.name());
            }

            return isCompatible(actualBase, expectedBase);
        }

        if (actual.isID() && expected.isID()) {
            IDType actualId = (IDType)actual;
            IDType expectedId = (IDType)expected;

            if (actualId.name.equals(expectedId.name)) {
                return true;
            }
            if ("Object".equals(expectedId.name)) {
                return true;
            }

            ClassDecl expectedClass = expectedId.link;
            for (ClassDecl curr = actualId.link; curr != null; curr = curr.superLink) {
                if (curr == expectedClass) return true;
                if (curr.name != null && curr.name.equals(expectedId.name)) return true;
            }
            return false;
        }
        return actual.name().equals(expected.name());
    }

    boolean isReferenceType(Type t) {
        return t != null && (t.isID() || t.isArray() || t.isNull());
    }


}

