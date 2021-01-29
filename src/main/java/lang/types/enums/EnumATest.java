package lang.types.enums;

public class EnumATest {
    public static void main(String[] args) {

        try {
            System.out.println(EnumA.valueOf(null));
        } catch (Throwable te) {
            System.out.println(te instanceof NullPointerException);
            // Name is null
            System.out.println(te.getMessage());
        }

        try {
            System.out.println(EnumA.valueOf("x"));
        } catch (Throwable te) {
            System.out.println(te instanceof IllegalArgumentException);
            // No enum constant lang.types.enums.demo1.TEnum.x
            System.out.println(te.getMessage());
        }

        System.out.println(EnumA.valueOf("T1"));

        System.out.println(EnumA.valueOf("T2"));

        EnumA.doStaticSth();
        EnumA.T1.doSth();
        EnumA.T2.doSth();

        EnumA t1 = EnumA.valueOf("T1");
        System.out.println(t1 == EnumA.T1);
        System.out.println(t1 != EnumA.T1);
        System.out.println(EnumA.T1.equals(t1));
    }
}
