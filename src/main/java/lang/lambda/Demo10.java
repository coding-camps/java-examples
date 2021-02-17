package lang.lambda;


@FunctionalInterface
interface MyCal {
    int cal(int a, int b);

}

public class Demo10 {


    public int calDemo(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {
        Demo10 demo10 = new Demo10();
        // 方法引用
        MyCal c = demo10::calDemo;
        int result = c.cal(200, 2);
        System.out.println(result);

    }


}
