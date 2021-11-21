package monoStackRelated;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

public class TrappingWater {

    public int trap(int[] height) {
        int res = 0;
        Deque<Integer> stack = new LinkedList();
        for (int i=0; i<height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int cur = height[stack.pop()];
                int h =  Math.min(height[stack.peek()], height[i]);
                int w =  i - stack.peek() - 1;
                res += (h - cur) * w;
            }
            stack.push(i);
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(nums));
    }
}
