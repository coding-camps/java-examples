package lang.thread.demo01;

public class ThreadB implements Runnable {
    private int sleepMillis;

    public ThreadB(int sleepMillis) {
        this.sleepMillis = sleepMillis;
    }

    @Override
    public void run() {
        System.out.println(this.getClass().getName() + " - started");
        try {
            java.lang.Thread.sleep(sleepMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getClass().getName() + " - ended");
    }
}
