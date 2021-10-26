public class WB1 {
    public static void main(String[] args) {
        Print print = new Print();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                print.printA();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                print.printB();
            }
        }).start();
    }

}

class Print {
    private boolean flag = false;

    public synchronized void printA() {
        while (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("A");
        flag = true;
        this.notify();
    }

    public synchronized void printB() {
        while (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("B");
        flag = false;
        this.notify();
    }
}

