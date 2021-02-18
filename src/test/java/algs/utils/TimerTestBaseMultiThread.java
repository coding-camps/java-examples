package algs.utils;

import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.time.Duration;
import java.util.Arrays;


//@Execution(ExecutionMode.CONCURRENT)
public interface TimerTestBaseMultiThread {

    ThreadLocal<Stopwatch> threadLocalStopwatch = new ThreadLocal<>();

    @BeforeEach
//    @Execution(ExecutionMode.CONCURRENT)
    default void beforeEachThreadTest() {
        System.out.println("Thread ID: " + Thread.currentThread().getId());
        Stopwatch stopwatch = Stopwatch.createStarted();
        threadLocalStopwatch.set(stopwatch);
    }

    @AfterEach
//    @Execution(ExecutionMode.CONCURRENT)
    default void afterEachThreadTest() {
        Stopwatch stopwatch = threadLocalStopwatch.get();
        Duration duration = stopwatch.elapsed();
        System.out.println("Spent time: " + duration);
        stopwatch.stop();
    }

}
