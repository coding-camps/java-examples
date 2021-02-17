package patterns.s2_proxy.steady;

public class MySerivceImpl implements MyService {
    @Override
    public void update() {
        System.out.println("Update system info.");
    }

    @Override
    public Object find() {
        System.out.println("Find object from system.");
        return new Object();
    }
}

