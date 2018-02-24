import java.util.Stack;

/**
 * Created by Fei on 1/16/2018.
 */
public class ValidParentheses {
    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack();
        char[] charArray = s.toCharArray();
        for (int i=0;i<charArray.length;i++) {
            if (!stack.isEmpty() && stack.peek() == charArray[i]) {
                stack.pop();
            } else {
                stack.push(charArray[i]);
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        validParentheses.isValidParentheses("()");
    }
}
