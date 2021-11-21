package dailyQuest;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

public class VerifyBinarySearchTreePreOrder {

    public boolean solution(int[] preOrder) {
        Deque<Integer> stack = new LinkedList<>();
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < preOrder.length; i++) {
            if (preOrder[i] < min) {
                return false;
            }
            if (stack.isEmpty() || stack.peek() > preOrder[i]) {
                stack.push(preOrder[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() < preOrder[i]) {
                    min = stack.pop();
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[] arr = {5,2,1,3,6,4};
        System.out.println(solution(arr));
    }


}
