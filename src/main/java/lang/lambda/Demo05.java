package lang.lambda;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Demo05 {

    // 归约
    public static void main(String[] args) {
        int[] intArray = IntStream.range(1, 11).toArray();
        System.out.println(Arrays.toString(intArray));

        int sum = 0;
        for (int i : intArray) {
            sum += i;
        }
        System.out.println("sum = " + sum);

        int sum1 = Arrays.stream(intArray).reduce(0, (a, b) -> a + b);
        System.out.println("sum1 = " + sum1);

        int sum2 = Arrays.stream(intArray).sum();
        System.out.println("sum2 = " + sum2);
    }
}
