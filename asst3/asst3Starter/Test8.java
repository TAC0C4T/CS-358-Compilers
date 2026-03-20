class Main extends Lib {
    public void main() {
        new TestPredefined().run();
    }
}

class TestPredefined extends Lib {
    public void run() {
        // String methods
        String s1 = "hello";
        String s2 = "world";
        String s3 = s1.concat(s2);
        int len = s1.length();
        int c = s1.charAt(0);
        int cmp = s1.compareTo(s2);
        String sub = s1.substring(0, 3);
        boolean eq = s1.equals(s2);

        // Lib methods
        printStr(s1);
        printInt(len);
        printBool(eq);
        String converted = intToString(len);
        printStr(converted);

        // Object methods
        String str = s1.toString();
        int hash = s1.hashCode();
        boolean equals = s1.equals(s2);

        // new objects
        TestChild tc = new TestChild();
        tc.init(42, "test");
        tc.run();
    }
}

class TestChild extends Lib {
    int value;
    String name;

    public void init(int v, String n) {
        value = v;
        name = n;
    }

    public void run() {
        printInt(value);
        printStr(name);
        String s = intToString(value);
        int len = s.length();
        printInt(len);
        boolean eq = s.equals(name);
        printBool(eq);
    }

    public int compute(int x) {
        int result = x + value;
        return result;
    }
}

class TestExtendChild extends TestChild {
    int extra;

    public void run() {
        super.run();
        extra = value + 1;
        printInt(extra);
        String s = intToString(extra);
        printStr(s);
    }
}