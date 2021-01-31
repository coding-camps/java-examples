package lang.exceptions;

public class ErrorFlows {

    public static void testCatchError() {
        try{
            throw new Error("My error message.");
        } catch (Error e) {
            e.printStackTrace();
        }
    }
}
