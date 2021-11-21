package calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculator {

    public int calculate(String s) {
        s = s.replaceAll("\\s", "");
        StringBuilder sb = new StringBuilder();
        sb.append('+');
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            sb.append(ch);
            if (ch == '(') {
                sb.append('+');
            }

        }
        String newString = sb.toString();
        int sum = 0, sign = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> signStack = new ArrayDeque<>();
        for (int i = 0; i < newString.length(); i++) {
            char ch = newString.charAt(i);
            if (ch == '+' || ch == '-') {
                sign = ch == '+' ? 1 : -1;
            } else if (Character.isDigit(ch)) {
                int i0 = i;
                while (i + 1 < newString.length() && Character.isDigit(newString.charAt(i + 1))) {
                    i++;
                }
                sum = sum + sign * Integer.parseInt(newString.substring(i0, i + 1));
            } else if (ch == '(') {
                stack.push(sum);
                signStack.push(sign);
                sum = 0;
                sign = 1;
            } else if (ch == ')') {
                sum = sum * signStack.pop() + stack.pop() ;
            }

        }
        return sum;
    }


    @Test
    public void test() {
        String s = "2147483647";
        System.out.println(calculate(s));
    }

}
