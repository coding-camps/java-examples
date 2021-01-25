package lang.annotation.repeatable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        inspectHuman(new Programmer());
        inspectHuman(new ProjectManager());
    }

    private static void inspectHuman(Human man) {
        System.out.println();
        System.out.println("这个人是个：" + man.getClass().getSimpleName());
        Set<Class> classes = new HashSet<>();
        classes.addAll(Arrays.asList(man.getClass().getInterfaces()));
        classes.add(man.getClass());
        for (Class<?> clz : classes) {
            Skill[] skills = clz.getAnnotationsByType(Skill.class);
            for (Skill skill : skills) {
                System.out.println("这个人会：" + skill.value());
            }
        }
    }
}
