package lang.thread.demo01;

public class ThreadA extends Thread {
    private int sleepMillis;

    public ThreadA(int sleepMillis) {
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
