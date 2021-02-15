package lang.thread.d1_priority;

import java.util.Arrays;
//import java.util.concurrent.atomic.AtomicInteger;

public class PriorityThread extends Thread {


    public static void main(String[] args) {
        final int THREAD_NUM = 200;
        PriorityThread[] threads = new PriorityThread[THREAD_NUM];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new PriorityThread();
            int p = i * 10 / THREAD_NUM + 1;
            threads[i].setPriority(p);
        }

        Arrays.stream(threads).forEach(t -> t.start());


        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Arrays.stream(threads).forEach(t -> t.stop());
//        Arrays.stream(threads).forEach(t -> t.setStop());

        for (int i = 0; i < threads.length; i++) {
            System.out.println(threads[i].getOpportunityInfo());
        }
    }


    private static int threadNo = 1;

    public PriorityThread() {
        super(String.format("PriorityThread-%03d", threadNo));
        threadNo++;
    }

//    private boolean isStopped = false;
//    public void setStop() {
//        this.isStopped = true;
//    }

    //    private AtomicInteger opportunities = new AtomicInteger(1);
    private long opportunities = 0;

    public String getOpportunityInfo() {
        return String.format("%s (P:%3d) %d", this.getName(), this.getPriority(), this.opportunities);
    }


    @Override
    public void run() {
        for (int i = 0; ; i++) {

//            if (this.isStopped) {
//                break;
//            }
//            this.opportunities.incrementAndGet();
            this.opportunities++;
        }
    }
}
