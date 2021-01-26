package lang.stream;

import java.util.Arrays;

public class StreamDemo2 {


    public static int sumByFor(int[] array) {
        int sum = 0;
        for (int item : array) {
            sum += item;
        }
        return sum;
    }

    public static int sumByWhile(int[] array) {
        int sum = 0;
        int i = 0;
        while (i < array.length) {
            sum += array[i++];
        }
        return sum;
    }

    public static int sumByLambdaSum(int[] array) {
        return Arrays.stream(array).sum();
    }

    public static int sumByLambdaReduce(int[] array) {
        return Arrays.stream(array).reduce((a, b) -> a + b).getAsInt();
    }

    public static int sumByRecursion(int[] array) {
        return recursition(array)[0];
    }

    private static int[] recursition(int[] array) {
        if (array.length == 1) {
            // return new int[] {array[0]};
            return array;
        } else {
            array[0] += array[array.length - 1];
            return recursition(Arrays.copyOf(array, array.length - 1));
        }
    }

}
