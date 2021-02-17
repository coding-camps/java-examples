package lang.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Demo09 {
    // 流式操作

    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "orange");
        List<String> list2 = new ArrayList<>();

        for (String s: list) {
            if(s.startsWith("a")) {
                list2.add(s.toUpperCase());
            }
        }

        Collections.sort(list2);
        System.out.println(list2);


        List<String> list3 = list.stream()
                .filter(s -> s.startsWith("a"))
                .map(String::toUpperCase)
                .sorted().collect(Collectors.toList());
        System.out.println(list3);

    }
}
