package utils;

public class ReflectUtil {

    public static String currentMethodInfo() {
        StackTraceElement[] traces = Thread.currentThread().getStackTrace();
        int index = 2;
        String className = traces[index].getClassName();
        String methodName = traces[index].getMethodName();
        return className + "." + methodName;
    }

    public static String currentCodeLineInfo() {
        StackTraceElement[] stackTrace = new Exception().getStackTrace();
        StringBuilder result = new StringBuilder();
        result.append(stackTrace[1].getClassName());
        result.append(".").append(stackTrace[1].getMethodName());
        result.append(":").append(stackTrace[1].getLineNumber());
        return result.toString();
    }

}
