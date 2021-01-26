package lang.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StreamDemo1 {

    public static void main(String[] args) {
        System.out.println(1);
        List<String> list1 = Arrays.asList("banana", "apple", "orange");
        System.out.println(list1);
        Collections.sort(list1, String::compareTo);
        list1.stream().forEach(System.out::println);

        System.out.println(2);
        List<String> list2 = Arrays.asList("banana", "apple", "orange");
        System.out.println(list2);
        list2.stream().sorted((a, b) -> a.compareTo(b)).forEach(System.out::println);
        System.out.println(list2);
        list2.stream().sorted(String::compareTo).forEach(System.out::println);
        System.out.println(list2);

        // 遍历
        System.out.println(3);
        list2.forEach(System.out::println);

    }

}
