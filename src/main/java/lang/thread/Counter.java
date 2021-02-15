package lang.thread;

public class Counter {

    private static long no = 0;

    public static void increase() {
        no++;
    }

    public static void printInfo() {
        System.out.println("No = " + no);
    }

}
