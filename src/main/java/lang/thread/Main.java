package lang.thread;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {

                for (int j = 0; j < 100000; j++) {
                    Counter.increase();
                }

            }).start();
        }
        Counter.printInfo();
    }
}
