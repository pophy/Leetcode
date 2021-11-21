package parentheses;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {

    public List<Integer> diffWaysToCompute(String expression) {
        char[] chars = expression.toCharArray();
        List<Integer> res = new ArrayList();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> first = diffWaysToCompute(expression.substring(0, i));
                List<Integer> second = diffWaysToCompute(expression.substring(i + 1, expression.length()));
                for (int n : first) {
                    for (int m : second) {
                        if (ch == '+') {
                            res.add(n + m);
                        } else if (ch == '-') {
                            res.add(n - m);
                        } else {
                            res.add(n * m);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.parseInt(expression));
        }
        return res;
    }

    @Test
    public void test() {
        diffWaysToCompute("2*3-4*5").stream().forEach(n -> System.out.println(n));
    }
}
