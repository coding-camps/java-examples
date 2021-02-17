package patterns.b3_template.demo1;

public class Main {
    public static void main(String[] args) {
        AbstractTemplate template = null;

        System.out.println("Case 1");
        template = new ConcreteTemplate1();
        template.doSthBy2Steps();

        System.out.println("Case 2");
        template = new ConcreteTemplate2();
        template.doSthBy2Steps();
    }
}
