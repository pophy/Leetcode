package calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculatorIII {
    int i = 0;

    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char operation = '+';
        int num = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            i++;
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (c == '(') {
                num = calculate(s);
            }
            if (i >= s.length() || !Character.isDigit(c)) {
                if (operation == '+') {
                    stack.push(num);
                } else if (operation == '-') {
                    stack.push(-num);
                } else if (operation == '*') {
                    stack.push(stack.pop() * num);
                } else if (operation == '/') {
                    stack.push(stack.pop() / num);
                }
                operation = c;
                num = 0;
            }
            if (c == ')') {
                break;
            }
        }
        return stack.stream().mapToInt(x -> x).sum();
    }

    @Test
    public void test() {
        String str = "(2+6*3-(14/7))+2";
        System.out.println(calculate(str));
    }


}
