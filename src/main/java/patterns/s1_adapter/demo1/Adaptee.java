package patterns.s1_adapter.demo1;

import utils.ReflectUtil;

public class Adaptee {
    public void doOper1() {
        System.out.println(ReflectUtil.currentMethodInfo());
    }
}
