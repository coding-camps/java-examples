package patterns.b5_command.demo1;


import utils.ReflectUtil;

public class Receiver {
    public Receiver() {
    }

    public void action() {
        System.out.println(ReflectUtil.currentMethodInfo());
    }
}

