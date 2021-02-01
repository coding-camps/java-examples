package lang.reflect;

import utils.ReflectUtil;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * [关于Java 8：如何获取由lambda生成的方法的名称](https://www.codenong.com/47313521/)
 */
public class LambdaMethods {


    public static void main(String[] args) {

        Stream.of(LambdaMethods.class.getDeclaredMethods())
                .forEach(System.out::println);

        System.out.println("current method: " + ReflectUtil.currentMethodInfo());
        System.out.println("current code line:" + ReflectUtil.currentCodeLineInfo());
    }

    public static void foo() {
        Consumer<Integer> c1 = n -> {
        };
        Supplier<String> sp1 = () -> "i am sp1";
        Supplier<String> sp2 = () -> "i am sp2";
    }

    public void bar() {
        Consumer<String> c2 = s -> {
        };
        Supplier<Integer> sp3 = () -> 3;
        Supplier<Integer> sp4 = () -> 4;
    }

}
