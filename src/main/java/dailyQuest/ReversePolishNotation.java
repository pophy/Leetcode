package dailyQuest;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class ReversePolishNotation {


    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for (String c : tokens) {
            if (isNumeric(c)) {
                stack.push(Integer.parseInt(c));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int temp = calculate(num1,num2,c);
                stack.push(temp);
            }
        }
        return stack.pop();
    }

    private int calculate(int num1, int num2, String operation) {

        switch (operation) {
            case "+": {
                return num1 + num2;
            }
            case "-": {
                return num1 - num2;
            }
            case "*": {
                return num1 * num2;
            }
            case "/": {
                return num1 / num2;
            }
            default: {
                return 0;
            }
        }
    }


    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    @Test
    public void test() {
        String[] exp = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(exp));
    }

}
