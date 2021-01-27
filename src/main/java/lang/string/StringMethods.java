package lang.string;

public class StringMethods {

    public static void main(String[] args) {
        testJoin();
        testReplace();
        testReplaceAll();
    }

    private static void testJoin() {
        System.out.println("-------- join() ---------");

        System.out.println(String.join("-", "a", "b", "c"));

        String[] strArray = {"A", "B", "C"};
        System.out.println(String.join("=", strArray));
    }


    public static void testReplace() {
        System.out.println("-------- replace() ---------");
        String s1 = "ABC";
        System.out.println(s1 + "\t\t" + s1.replace("A", "[X]"));
        System.out.println(s1 + "\t\t" + s1.replace("ABC", "[Z]"));
        String s3 = "ABCABCABC";
        System.out.println(s3 + "\t\t" + s3.replace("A", "[X]"));
        System.out.println(s3 + "\t\t" + s3.replace("ABC", "[Z]"));

        // 不支持正则表达式替换
        String sx1 = "ABC123";
        System.out.println(sx1 + "\t\t" + sx1.replace("\\d", "*"));
        String sx2 = "ABC123ABC123";
        System.out.println(sx2 + "\t\t" + sx2.replace("\\d", "*"));
    }


    public static void testReplaceAll() {
        System.out.println("-------- replaceAll() ---------");
        String s1 = "ABC";
        System.out.println(s1 + "\t\t" + s1.replaceAll("A", "[X]"));
        System.out.println(s1 + "\t\t" + s1.replaceAll("ABC", "[Z]"));
        String s3 = "ABCABCABC";
        System.out.println(s3 + "\t\t" + s3.replaceAll("A", "[X]"));
        System.out.println(s3 + "\t\t" + s3.replaceAll("ABC", "[Z]"));

        // 支持正则表达式替换
        String sx1 = "ABC123";
        System.out.println(sx1 + "\t\t" + sx1.replaceAll("\\d", "*"));
        String sx2 = "ABC123ABC123";
        System.out.println(sx2 + "\t\t" + sx2.replaceAll("\\d", "*"));
    }

}
