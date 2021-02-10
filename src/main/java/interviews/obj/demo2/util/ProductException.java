package interviews.obj.demo2.util;

/**
 * 异常类
 */
public class ProductException extends Exception {

    public ProductException(Throwable ex) {
        super(ex.getMessage());
    }

    public ProductException(String strMsg) {
        super(strMsg);
    }

    public ProductException(String strMsg, Throwable ex) {
        super(strMsg);
    }
}
