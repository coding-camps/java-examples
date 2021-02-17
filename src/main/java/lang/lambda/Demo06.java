package lang.lambda;

import java.util.*;
import java.util.stream.Collectors;

public class Demo06 {

    // 分组
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "orange");
        System.out.println(list);

        Map<Integer, List<String>> groups = new HashMap<>();
        for (String f : list) {
            int len = f.length();
            if (!groups.containsKey(len)) {
                groups.put(len, new ArrayList<>());
            }
            groups.get(len).add(f);
        }
        System.out.println(groups);

        Map<Integer, List<String>> groups2 = list.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(groups2);


    }
}
