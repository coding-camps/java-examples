package patterns.b3_template.demo1;
import utils.ReflectUtil;

public class ConcreteTemplate1 extends AbstractTemplate {
    @Override
    public void firstStep() {
        System.out.println(ReflectUtil.currentMethodInfo());
    }

    @Override
    public void secondStep() {
        System.out.println(ReflectUtil.currentMethodInfo());
    }
}
