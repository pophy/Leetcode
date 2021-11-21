package monoStackRelated;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            q.add(i);
            if (q.peekFirst() == i - k) {
                q.pollFirst();
            }
            if (i >= k - 1) {
                res[index++] = nums[q.peekFirst()];
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {7, 2, 4};
        Arrays.stream(maxSlidingWindow(nums,2)).forEach(n -> {
            System.out.print(n + ", ");
        });
    }

}
