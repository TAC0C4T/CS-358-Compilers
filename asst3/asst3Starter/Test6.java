class Main extends Lib {
    public void main() {
        new SwitchTest().run();
    }
}

class SwitchTest extends Lib {
    int x;

    public void run() {
        int c = 5;
        switch (c) {
            case 0:
                int y = 10;
                break;
            case 1:
                int y = 20;
                break;
            case 2:
                int z = y + 1;
                break;
        }
    }
}