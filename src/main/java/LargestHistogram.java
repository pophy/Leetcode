import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Fei on 2/15/2018.
 */
public class LargestHistogram {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] newHeight = new int[height.length + 2];
        int max = 0;
        System.arraycopy(height, 0, newHeight, 1, height.length);
        //store index in stack
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < newHeight.length; i++) {
            while (newHeight[stack.peek()] > newHeight[i]) {
                int h = newHeight[stack.pop()];
                int w = i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }

        return max;
    }

    public static void main(String[] args) {
        LargestHistogram largestHistogram = new LargestHistogram();
        int[] ds = {2, 1, 2};
        System.out.println(largestHistogram.largestRectangleArea(ds));
    }
}
