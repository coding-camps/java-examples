package lang.math;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomMath {
    public static void main(String[] args) {
        int origin = 1, bound = 10;
        int numOfValue = 20;
        long seed = LocalDateTime.now().getDayOfYear();
        m10(origin, bound, numOfValue);
        m11(origin, bound, numOfValue);
        m12(origin, bound, numOfValue);
        m13(origin, bound, numOfValue);
        m2(origin, bound, numOfValue, seed);
        m3(origin, bound, numOfValue);
        m4(origin, bound);
        m5(origin, bound);
    }

    /**
     * {@link java.security.SecureRandom}
     */
    public static void m5(int min, int max) {
        System.out.println(" - - - - - - - - - - java.security.SecureRandom");
    }

    /**
     * {@link java.util.SplittableRandom}
     */
    public static void m4(int min, int max) {
        System.out.println(" - - - - - - - - - - java.util.SplittableRandom");
        SplittableRandom splittableRandom = new SplittableRandom();
        int r41 = splittableRandom.nextInt(min, max);
        IntStream intStream = splittableRandom.ints(min, max);
        int r42 = intStream.findFirst().getAsInt();
        System.out.printf("%d, %d%n", r41, r42);
    }

    /**
     * {@link java.util.concurrent.ThreadLocalRandom}
     */
    public static void m3(int min, int max, int numOfValue) {
        System.out.println(" - - - - - - - - - - java.util.concurrent.ThreadLocalRandom");
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        Function<ThreadLocalRandom, String> fun1 = (rdm) ->
                IntStream.range(0, numOfValue)
                        .map(i -> rdm.nextInt(min, max))
                        .mapToObj(j -> String.format("%d", j))
                        .collect(Collectors.joining(","));
        System.out.println(fun1.apply(tlr));

        Function<ThreadLocalRandom, String> func2 = (rdm) ->
                rdm.ints(numOfValue, min, max)
                        .mapToObj(i -> String.format("%d", i))
                        .collect(Collectors.joining(","));
        System.out.println(func2.apply(tlr));
    }

    /**
     * {@link java.util.Random}
     */
    public static void m2(final int min, final int max, int numOfValue, long seed) {
        System.out.println(" - - - - - - - - - - java.util.Random");
        System.out.println(String.format("Same seed: %d", seed));

        Function<Random, String> func1 = (rdm) -> {
            return IntStream.range(0, numOfValue)
                    .map(i -> rdm.nextInt(max - min) + min)
                    .mapToObj(j -> String.format("%d", j))
                    .collect(Collectors.joining(","));
        };
        System.out.println(func1.apply(new Random(seed)));
        System.out.println(func1.apply(new Random(seed)));

        Function<Random, String> func2 = (rdm) -> {
            return rdm.ints(numOfValue, min, max)
                    .mapToObj(j -> String.format("%d", j))
                    .collect(Collectors.joining(","));
        };
        System.out.println(func2.apply(new Random(seed)));
        System.out.println(func2.apply(new Random(seed)));
    }

    /**
     * {@link java.lang.Math}
     */
    public static void m10(int min, int max, int numOfValue) {
        System.out.println(" - - - - - - - - - - java.lang.Math");
        int[] range = IntStream.range(0, numOfValue).toArray();
        for (int i : range) {
            int r = (int) (Math.random() * (max - min) + min);
            System.out.printf(i == numOfValue - 1 ? "%d" : "%d,", r);
        }
        System.out.println();
    }

    /**
     * {@link java.lang.Math}
     */
    public static void m11(int min, int max, int numOfValue) {
        System.out.println(" - - - - - - - - - - java.lang.Math");
        Supplier<String> supplier = () -> {
            // method 1
            StringBuilder builder = new StringBuilder();
            for (int i : IntStream.range(0, numOfValue).toArray()) {
                int r = (int) (Math.random() * (max - min) + min);
                builder.append(r).append(",");
            }
            return builder.toString().substring(0, builder.length() - 1);
        };

        System.out.println(supplier.get());
    }

    /**
     * {@link java.lang.Math}
     */
    public static void m12(int min, int max, int numOfValue) {
        System.out.println(" - - - - - - - - - - java.lang.Math");
        Supplier<String> supplier = () -> {
            // method 2
            StringBuilder builder = new StringBuilder();
            IntStream.range(0, numOfValue)
                    .map(i -> (int) (Math.random() * (max - min) + min))
                    .mapToObj(j -> String.format("%d", j))
                    .forEach(s -> builder.append(s).append(","));
            return builder.toString().substring(0, builder.length() - 1);
        };

        System.out.println(supplier.get());

    }

    /**
     * {@link java.lang.Math}
     */
    public static void m13(int min, int max, int numOfValue) {
        System.out.println(" - - - - - - - - - - java.lang.Math");
        Supplier<String> supplier = () -> {
            // method 3
            return IntStream.range(0, numOfValue)
                    .map(i -> (int) (Math.random() * (max - min) + min))
                    .mapToObj(j -> String.format("%d", j))
                    .collect(Collectors.joining(","));
        };
        System.out.println(supplier.get());
    }
}
