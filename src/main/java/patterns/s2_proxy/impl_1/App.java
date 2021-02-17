package patterns.s2_proxy.impl_1;

public class App {
    public static void main(String[] args) {
        UserDao target = new UserDao();
        UserDaoProxy proxy = new UserDaoProxy(target);
        proxy.save();
    }
}
