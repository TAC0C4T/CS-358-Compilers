package visitor;

import errorMsg.*;
import java.util.*;
import syntaxtree.*;

// the purpose of this class is to
// - link each ClassDecl to the ClassDecl for its superclass 
//    (via its 'superLink')
// - link each ClassDecl to each of its subclasses 
//    (via the 'subclasses' instance variable)
// - ensure that there are no cycles in the inheritance hierarchy
// - ensure that no class has 'String' or 'RunMain' as its superclass
public class Sem2Visitor extends Visitor
{

    HashMap<String,ClassDecl> classEnv;
    ErrorMsg errorMsg;

    public Sem2Visitor(HashMap<String,ClassDecl> env, ErrorMsg e)
    {
        errorMsg = e;
        classEnv = env;
    }

    @Override
    public Object visit(Program p) {
        p.predefinedDecls.accept(this);
        p.classDecls.accept(this);
        return null;
    }

    @Override
    public Object visit(ClassDecl c) {
        if (c.pos == -1) {
            return null;
        }
        if (c.superName == null || c.superName.equals("")) {
            return null;
        }
        if (c.superName.equals("String") || c.superName.equals("RunMain")) {
            errorMsg.error(c.pos, CompError.IllegalSuperclass(c.name));
            return null;
        }
        if (!classEnv.containsKey(c.superName)) {
            errorMsg.error(c.pos, CompError.UndefinedSuperclass(c.superName));
            return null;
        }

        c.superLink = classEnv.get(c.superName);
        c.superLink.subclasses.add(c);
        if (superRecurse(c.superLink, c.name)) {
            errorMsg.error(c.pos, CompError.InheritanceCycle(c.name));
        }
        return null;
    }

    private boolean superRecurse(ClassDecl c, String loc) {
        if (c == null) {
            return false;
        }
        if (c.name.equals(loc)) {
            return true;
        }
        return superRecurse(c.superLink, loc);
    }



}
