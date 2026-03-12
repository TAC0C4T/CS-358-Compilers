class Main extends Lib {
    public void main() {
        new TestRunner().run();
    }
}

class TestRunner extends Lib {
    int x;
    int length;

    public void run() {
        int a = a + 1;
        int b = a + 1;

        int c = 5;
        int c = 6;

        switch (c) {
            case 0:
                int y = 10;
                break;
            case 1:
                y = 20;
                break;
            case 2:
                int z = y + 1;
                break;
        }

        break;

        while (c > 0) {
            int i = 0;
            c = c - 1;
            if (c == 2) {
                break;
            }
        }

        int i = 0;

        String s = "hello";
        int len = s.length();
    }
}

class Child extends TestRunner {
    int extra;

    public void test() {
        int val = x + extra;
        int val2 = length + 1;
    }
}

class BadCycle1 extends BadCycle2 {
}

class BadCycle2 extends BadCycle1 {
}

class BadSuper1 extends String {
}

class BadSuper2 extends RunMain {
}