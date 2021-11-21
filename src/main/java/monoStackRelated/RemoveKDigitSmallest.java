package monoStackRelated;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveKDigitSmallest {

    public String removeKdigits(String num, int k) {
        if (num == null || k >= num.length()) {
            return "0";
        }
        LinkedList<Character> stack = new LinkedList();
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && stack.peek() > num.charAt(i) && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while (k-- > 0) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = stack.size() - 1; i >= 0; i--) {
            sb.append(stack.get(i));
        }
        while (sb.length() != 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    @Test
    public void test() {
        System.out.println(removeKdigits("112", 1));
    }
}
