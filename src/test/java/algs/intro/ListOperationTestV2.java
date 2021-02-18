package algs.intro;

import algs.utils.TimerTestBaseMultiThread;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

//@Execution(ExecutionMode.SAME_THREAD)
public class ListOperationTestV2 implements TimerTestBaseMultiThread {

    static public Stream<Arguments> provideListAddArgs() {
        int testLen = 900_0000;
        System.out.println("provideListAddArgs");
        return Stream.of(Arguments.of(new LinkedList<Integer>(), testLen), Arguments.of(new ArrayList<Integer>(), testLen));
    }

    //    @ParameterizedTest(name = "add [{index}]: {argumentsWithNames}")
    //https://junit.org/junit5/docs/current/user-guide/
    @ParameterizedTest
    @Execution(ExecutionMode.CONCURRENT)
    @MethodSource("provideListAddArgs")
    public void testListAdd(List<Integer> list, int testLen) {
        ListOperation.listAdd(list, testLen);
    }
}
