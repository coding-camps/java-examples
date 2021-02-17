package patterns.s1_adapter.demo1;

import utils.ReflectUtil;

public class Adapter extends Adaptee implements Target {

    @Override
    public void doOper2() {
        System.out.println(ReflectUtil.currentMethodInfo());
    }

}
