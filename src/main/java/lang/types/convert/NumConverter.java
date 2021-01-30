package lang.types.convert;

import java.math.BigInteger;

public class NumConverter {

    public static void main(String[] args) {
        convertFloatToInteger();
    }

    public static void convertFloatToInteger() {
        // java.lang.NumberFormatException: For input string: "201.0"
        try {
            System.out.println(new BigInteger("201.0").toString());
        } catch (Throwable e) {
            System.out.println("Type: " + e.getCause());
            System.out.println("Message: " + e.getMessage());
        }
        // java.lang.NumberFormatException: For input string: "201.0"
        try {
            System.out.println(Integer.valueOf("201.0"));
        } catch (Throwable e) {
            System.out.println("Type: " + e.getCause());
            System.out.println("Message: " + e.getMessage());
        }
        System.out.println(Double.valueOf("201.0").intValue() + "");
        System.out.println(Double.valueOf("201.1").intValue() + "");
        System.out.println(Double.valueOf("201.3").intValue() + "");
        System.out.println(Double.valueOf("201.5").intValue() + "");
        System.out.println(Double.valueOf("201.7").intValue() + "");
        System.out.println(Double.valueOf("201.9").intValue() + "");

        System.out.println(Double.valueOf("201.0").toString() + "");
        System.out.println(Double.valueOf("201.9").toString() + "");
    }
}
