package visitor;

import syntaxtree.*;

import java.util.*;

import errorMsg.*;
import java.io.*;

//the purpose here is to emit mips code to represent string literals.
public class CG2Visitor extends Visitor
{
    // IO stream to which we will emit code
    CodeStream code;

    // Environment for string to the first node that we found with that string.
    HashMap<String,StringLit> stringEnv;

    public CG2Visitor(ErrorMsg e, PrintStream out)
    {
        stringEnv = new HashMap<String,StringLit>();
        code = new CodeStream(out, e);
    }

    public Object visit(Program p)
    {
        // This generates MIPS for string literals,
        // however it does not account for duplicate strings.
        // In order to get == to work correctly,
        // you must create your own version which does account for duplicate
        // strings.
        //StrLitSimpleGenerator.generate(p,  code);

        code.emit(".data");
        super.visit(p);

        return null;
    }

    @Override
    public Object visit(StringLit s)
    {
        StringLit first = stringEnv.get(s.str);
        if (first != null) {
            s.uniqueCgRep = first;
            return null;
        }

        stringEnv.put(s.str, s);
        s.uniqueCgRep = s;

        code.emit("strLit" + s.uniqueId + ":");
        code.emit(".asciiz \"" + s.str + "\"");
        code.emit(".align 2");
        
        return null;
    }

}
