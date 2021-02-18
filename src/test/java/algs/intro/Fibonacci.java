package algs.intro;


public class Fibonacci {
    public static int fibNormal(int n) {
        if (n < 2) {
            return 1;
        }
        return fibNormal(n - 1) + fibNormal(n - 2);
    }

    public static int fibTail(int n) {
        return 1;
    }
}