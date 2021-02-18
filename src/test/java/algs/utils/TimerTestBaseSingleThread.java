package algs.utils;


import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.time.Duration;

/**
 *
 */
public interface TimerTestBaseSingleThread {

    Stopwatch stopwatch = Stopwatch.createStarted().reset();

    @BeforeEach
    default void beforeEachTest() {
//        boolean match = Arrays.asList(this.getClass().getInterfaces()).contains(TimerTestBaseMultiThread.class);
//        if (match) {
//            throw new IllegalThreadStateException("this class is in an single thread");
//        }
        long threadId = Thread.currentThread().getId();
        System.out.println("Thread ID: " + threadId);
        stopwatch.start();
    }

    @AfterEach
    default void afterEachTest() {
        Duration duration = stopwatch.elapsed();
        System.out.println("Spent time: " + duration);
        stopwatch.reset();
    }

}
