package divideConquer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        //base case
        if (input.length() == 1) {
            res.add(Integer.valueOf(input));
            return res;
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));
                for (int leftNum : left) {
                    for (int rightNum : right) {
                        switch (c) {
                            case '+':
                                res.add(leftNum + rightNum);
                                break;
                            case '-':
                                res.add(leftNum - rightNum);
                                break;
                            case '*':
                                res.add(leftNum * rightNum);
                                break;
                        }
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        String str = "1-2-3-4-5";
        diffWaysToCompute(str).stream().forEach(p -> {
            System.out.println(p);
        });
    }

}
