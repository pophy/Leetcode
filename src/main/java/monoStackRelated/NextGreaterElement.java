package monoStackRelated;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[stack.peek() % n] < nums[i % n]) {
                int preIndex = stack.pop();
                res[preIndex % n] = nums[i % n];
            }
            stack.push(i % n);
        }

        return res;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5};
        Arrays.stream(nextGreaterElements(nums)).forEach(n -> System.out.println(n + ", "));
    }

}
