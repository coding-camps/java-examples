package lang.thread.demo01;

public class App {
    public static void main(String[] args) {
        int sleepMilis = 1000;

        Thread t1 = new ThreadA(sleepMilis);
        Thread t2 = new Thread(new ThreadB(sleepMilis));
        Thread t3 = ThreadC.creadThread(sleepMilis);

        t1.start();
        t2.start();
        t3.start();
    }
}
