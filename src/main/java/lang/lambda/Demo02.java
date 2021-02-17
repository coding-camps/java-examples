package lang.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Demo02 {
    public static void main(String[] args) {
        // 集合排序
        List<String> list1 = Arrays.asList("banana", "apple", "orange");
        List<String> list2 = list1;

        System.out.println(list1);
        System.out.println(list2);

        Collections.sort(list1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });


        System.out.println(list1);

        Collections.sort(list2, (o1, o2) -> o1.compareTo(o2));
        System.out.println(list2);
    }


}
