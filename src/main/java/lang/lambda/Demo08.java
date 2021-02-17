package lang.lambda;

import java.util.Locale;
import java.util.Optional;

public class Demo08 {

    //Optional 避免空指针

    public static void main(String[] args) {
        String str = "Hello world~!";
        if(str!=null) {
            System.out.println(str.toUpperCase(Locale.ENGLISH));
        }

        Optional.ofNullable(str).map(String::toUpperCase).ifPresent(System.out::println);
    }

}
