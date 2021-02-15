package lang.concurrent.p0;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;


public class ThreadCreation1 {

    Thread t;

    public ThreadCreation1() throws Exception {
        Thread.sleep(1);
        t.join();
    }

    Thread.State state;

    Runnable r;
    Callable c;
    RunnableFuture rf;
    Future f;

    FutureTask ft;
}
