package lang.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo04 {

    // 映射
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "orange");
        System.out.println(list);

        List<Integer> listLen = new ArrayList<>();
        for (String fruit: list) {
            listLen.add(fruit.length());
        }
        System.out.println(listLen);

        List<Integer> listLenX = list.stream().map(f -> f.length()).toList();
        System.out.println(listLenX);
    }
}
