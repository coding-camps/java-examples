package lang.lambda;

import java.util.function.BiFunction;

@FunctionalInterface
interface SomeInterface {
    String repeat(char c, int times);
}


public class Demo11 {

    public static void main(String[] args) {
        BiFunction impl1 = (c, t) -> c + "|" + t;
        Object result1 = impl1.apply('B', 112233);
        System.out.println(result1);

        SomeInterface impl2 = (c, t) -> c + "|" + t;
        String result = impl2.repeat('A', 123);
        System.out.println(result);
    }
}
