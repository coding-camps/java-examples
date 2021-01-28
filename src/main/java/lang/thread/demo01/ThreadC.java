package lang.thread.demo01;

public class ThreadC {
    public static Thread creadThread(int sleepMillis) {
        return new Thread(() -> {
            System.out.println(ThreadC.class.getName() + " - started");
            try {
                Thread.sleep(sleepMillis);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            System.out.println(ThreadC.class.getName() + " - ended");
        });
    }
}
