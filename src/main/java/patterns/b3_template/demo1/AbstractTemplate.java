package patterns.b3_template.demo1;

import utils.ReflectUtil;

public abstract class AbstractTemplate {
    public abstract void firstStep();

    public abstract void secondStep();

    public void doSthBy2Steps() {
        System.out.print("================= begin\n => ");
        System.out.println(ReflectUtil.currentMethodInfo());
        System.out.println();
        firstStep();
        secondStep();
        System.out.println("========== end");
    }
}
