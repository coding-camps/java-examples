package lang.lambda;


interface MyInterface {
    void doSth(String str);
}

public class Demo07 {

    // 函数式接口。简化匿名类，常见的如线程创建


    public static void main(String[] args) {

        MyInterface myInterface = new MyInterface() {
            @Override
            public void doSth(String str) {
                System.out.println(str);
            }
        };

        myInterface.doSth("Hello World~!");


//        MyInterface myInterface1 = (String s) -> System.out.println(s);
        MyInterface myInterface1 = (s) -> System.out.println(s);
        myInterface1.doSth("Hello World~!");


    }

}
