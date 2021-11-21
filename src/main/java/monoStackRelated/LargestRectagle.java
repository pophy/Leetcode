package monoStackRelated;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectagle {

    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int res = 0;
        int[] copy = new int[height.length + 2];
        for (int i = 0; i < height.length; i++) {
            copy[i + 1] = height[i];
        }
        Deque<Integer> stack = new LinkedList();
        for (int i = 0; i < copy.length; i++) {
            while (!stack.isEmpty() && copy[stack.peek()] > copy[i]) {
                int h = stack.isEmpty() ? 0 : copy[stack.pop()];
                int w = stack.isEmpty() ? 0 : i - stack.peek() - 1;
                res = Math.max(res, h * w);
            }
            stack.push(i);
        }
        return res;
    }

    @Test
    public void test() {
        int[] m = {1};
        System.out.println(largestRectangleArea(m));
    }

}
