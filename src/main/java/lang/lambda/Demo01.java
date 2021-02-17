package lang.lambda;

import java.util.Arrays;
import java.util.List;

public class Demo01 {

    // 集合遍历
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "orange");


        // 1 古老用法
        for (String fruit : list) {
            System.out.println(fruit);
        }

        // lambda表达式
        list.stream().forEach(fruit -> System.out.println(fruit));

        // lambda表达式之方法引用
        list.stream().forEach(System.out::println);
    }

}
