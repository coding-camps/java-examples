package patterns.s2_proxy.steady;

public class MyServiceTest {
    public static void main(String[] args) {
        MyService myService = new MySerivceImpl();
        MyServiceProxy myServiceProxy = new MyServiceProxy(myService);
        System.out.println("---------- update");
        myServiceProxy.update();
        System.out.println("---------- find");
        myServiceProxy.find();
    }
}
