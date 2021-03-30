import java.util.Map;
import java.util.Properties;

public class JavaVersions {
    public static void main(String[] args) {
        System.out.println("Hello Java World~!");
        System.out.println("jdk标准版本号: " + System.getProperty("java.specification.version"));
        System.out.println("jdk详细版本号: " + System.getProperty("java.version"));
        System.out.println("JDK配置路径：" + System.getProperty("java.home"));
        System.out.println("默认编码：" + System.getProperty("sun.stdout.encoding"));
        System.out.println("Java class 文件版本：" + System.getProperty("java.class.version"));
        System.out.println("JDK 提供商及版本：" + System.getProperty("java.vendor.version"));

        boolean listAllProperties = false;
        if (listAllProperties) {
            System.out.println("全部");
            Properties props = System.getProperties();
            for (Map.Entry<Object, Object> prop : props.entrySet()){
                System.out.println(prop.getKey() + " -> " + prop.getValue());
            }

        }
    }
}
