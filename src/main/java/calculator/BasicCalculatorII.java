package calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculatorII {

    public int calculate(String s) {
        s = s.replaceAll("\\s", "");
        Deque<Integer> stack = new ArrayDeque<>();
        char operation = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int i0 = i;
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                }
                num = Integer.parseInt(s.substring(i0, i + 1));
                if (operation == '+') {
                    stack.push(num);
                } else if (operation == '-') {
                    stack.push(-num);
                } else if (operation == '*') {
                    stack.push(stack.pop() * num);
                } else if (operation == '/') {
                    stack.push(stack.pop() / num);
                }
            } else {
                operation = ch;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
    @Test
    public void test() {
        System.out.println(calculate("3/2"));
    }
}
