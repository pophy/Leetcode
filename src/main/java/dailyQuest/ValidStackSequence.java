package dailyQuest;

import java.util.Stack;

public class ValidStackSequence {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popedIndex = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[popedIndex]) {
                stack.pop();
                popedIndex++;
            }
        }
        return stack.isEmpty();
    }

}
