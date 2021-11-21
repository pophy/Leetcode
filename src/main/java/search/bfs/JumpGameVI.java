package search.bfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class JumpGameVI {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<int[]> deque = new ArrayDeque(); // int[0] ~ value, int[1] ~ pos
        deque.addLast(new int[]{nums[0], 0});
        for (int i = 1; i < n; i++) {
            //find max dp range from (i-k ~ i]
            if (i - deque.peekFirst()[1] > k) {
                deque.pollFirst();
            }
            int curScore = deque.peekFirst()[0] + nums[i];
            while (!deque.isEmpty() && deque.peekLast()[0] <= curScore) {
                deque.pollLast();
            }
            deque.addLast(new int[]{curScore, i});
        }
        return deque.peekLast()[0];
    }

    @Test
    public void test() {
        int[] nums = {1,-5,-20,4,-1,3,-6,-3};
        System.out.println(maxResult(nums, 2));
    }
}
