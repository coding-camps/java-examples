package games.demo02;

import java.util.Scanner;

/**
 * @author cosmos
 */
public class SimpleCalculator {
    private static Scanner scanner = new Scanner(System.in);
    private static double result = 0.0;
    private static double num1 = 0.0;
    private static double num2 = 0.0;

    public double getNumFromInput() {
        double num = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            if (scanner.hasNextDouble()) {
                // 合法输入
                num = scanner.nextDouble();
                isValidInput = true;
            } else {
                // 非法输入
                System.out.print("请重修输入数字：");
                scanner.next();
            }
        }
        return num;
    }

    private void run() {
        System.out.print("请输入一个数：");
        num1 = getNumFromInput();
        System.out.print("请输入运算符(+ - * /)：");
        String operator = scanner.next();
        System.out.print("请输入一个数：");
        num2 = getNumFromInput();
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                break;
        }
        System.out.print("结果为：" + result);

    }

    public static void main(String[] args) {
        SimpleCalculator calculator = new SimpleCalculator();
        calculator.run();
    }
}
