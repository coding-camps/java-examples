package lang.concurrent.p0;

public class ThreadJoin extends Thread {

    public static void main(String[] args) throws InterruptedException {
        ThreadJoin t1 = new ThreadJoin(1);
        ThreadJoin t2 = new ThreadJoin(2);
        System.out.println(t1.getState() + ":" + t2.getState());
        t1.start();
        t2.start();
        System.out.println(t1.getState() + ":" + t2.getState());
        Thread.sleep(100);
        t1.join(100);
        Thread.sleep(100);
        System.out.println(t1.getState() + ":" + t2.getState());
    }

    public ThreadJoin(int i) {
        this.setName("J-" + i);
    }

    @Override
    public void run() {
        String info1 = String.format("%s start", this.getName());
        System.out.println(info1);

        long sum = 0;
        for (long i = 0; i < 1000000000; i++) {
            sum += 1;
        }

        String info2 = String.format("%s end", this.getName());
        System.out.println(info2);
    }
}
