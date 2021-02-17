package lang.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo03 {

    // 集合过滤
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "orange");
        System.out.println(list);

        List<String> listf1 = new ArrayList<>();
        for (String fruit: list) {
            if(fruit.startsWith("a")) {
                listf1.add(fruit);
            }
        }
        System.out.println(listf1);

        List<String> listf2 = list.stream().filter(f -> f.startsWith("a")).collect(Collectors.toList());
        System.out.println(listf2);

        List<String> listf3 = list.stream().filter(f -> f.startsWith("a")).toList();
        System.out.println(listf3);
    }
}
