package patterns.s2_proxy.steady;

public class MyServiceProxy implements MyService {

    private MyService myService;

    public MyServiceProxy(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void update() {
        System.out.println(".. Check if the operator is a valid user for updating.");
        myService.update();
        System.out.println("... Log operation info, user info and timestamps for finding.");
    }

    @Override
    public Object find() {
        System.out.println(".. Check if the operator is a valid user for finding.");
        System.out.println("... Log operation info, user info and timestamps for finding");
        myService.find();
        return null;
    }
}
