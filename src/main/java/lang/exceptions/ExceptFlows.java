package lang.exceptions;

public class ExceptFlows {

    public static int testTry(boolean fireRuntimeException) {
        //try 语句块中有 return 语句时的整体执行顺序
        int i = 0;
        try {
            i++;
            System.out.println("try block, i = " + i);
            if (fireRuntimeException) {
                i = 1 / 0;
            }
            return i;
        } catch (Exception e) {
            i++;
            System.out.println("catch block i = " + i);
            return i;
        } finally {
//            i = 10;
            i++;
            System.out.println("finally block i = " + i);
        }
//        return i;
    }

    public static int catchFlow() {
        //try 语句块中有 return 语句时的整体执行顺序
        int i = 1;
        try {
            i++;
            System.out.println("try block, i = " + i);
            return i;
        } catch (Exception e) {
            i++;
            System.out.println("catch block i = " + i);
            return i;
        } finally {
            i = 10;
            System.out.println("finally block i = " + i);
        }
    }
}
