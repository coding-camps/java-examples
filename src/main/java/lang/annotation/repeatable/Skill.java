package lang.annotation.repeatable;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented

@Retention(RetentionPolicy.RUNTIME)//运行时注解
@Target(ElementType.TYPE)//类上的注解
@Repeatable(Skills.class)
public @interface Skill {

    String value() default "";
}
