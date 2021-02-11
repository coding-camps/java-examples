package bean;

import com.google.common.base.Preconditions;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Objects;

// A.isAssignableFrom(B)
// A和B均为Class对象，判断B是否等于/继承/实现A，是返回true，否返回false
// isPrimitive用于判断当前类型是否是原始类型，当前Class类定义了9中包装类型代表8中原始和void
// 8中基本类型分别为：boolean, byte, char, short, int, long, float, and double，9中包装类型分布为Boolean, Character, Byte, Short, Integer, Long, Float, Double, Void，可以通过包装类型的TYPE属性获取其基本类型。
// 一般基本类型存储在栈中，包装类存储在堆中，并且基本类的存取速度更快。
// 基本类型的包装类都采用final修饰方法，因此无法继承它们扩展的新类，也无法重写它们的方法。

public class BeanDemo {

    public static void main(String[] args) {
        PersonBean bean = new PersonBean("Gosling", 100);
        showBeanInfo(bean);
    }

    public static void showBeanInfo(Object bean) {
        Preconditions.checkNotNull(bean, "bean should be not null.");
        Class<?> beanClass = bean.getClass();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(beanClass);
            Arrays.stream(beanInfo.getPropertyDescriptors()).filter(descriptor -> {
                try {
                    return Objects.nonNull(beanClass.getDeclaredField(descriptor.getName()));
                } catch (NoSuchFieldException e) {
                    return false;
                }
            }).forEach(descriptor -> {
                try {
                    System.out.println("----------");
                    String propName = descriptor.getName();
                    Class<?> propType = descriptor.getPropertyType();
                    Field propField = beanClass.getDeclaredField(propName);
                    Method getter = descriptor.getReadMethod();
                    Method setter = descriptor.getWriteMethod();

                    // field / property
                    System.out.println("field");
                    System.out.println("Property Field: " + propField);
                    System.out.println("Property Name: " + propName);
                    System.out.println("Property Type: " + propType);
                    propField.setAccessible(true);
                    System.out.println("Property Value: " + propField.get(bean));

                    // getter
                    System.out.println("getter");
                    System.out.println("Getter Method: " + getter);
                    System.out.println("Getter Value: " + getter.invoke(bean));

                    // setter
                    System.out.println("setter");
                    System.out.println("Setter Method: " + setter);
                    Parameter[] params = setter.getParameters();
                    for (Parameter param : params) {
                        System.out.println("setter param type: " + param.getType());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (IntrospectionException e) {
            throw new RuntimeException(e);
        }


    }
}
