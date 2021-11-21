package dp;

import org.junit.jupiter.api.Test;

public class HouseRob {

    public int rob(int[] nums) {
        int n = nums.length;
        int[] rob = new int[n];
        int[] no_rob = new int[n];
        rob[0] = nums[0];
        for (int i = 1; i < n; i++) {
            rob[i] = no_rob[i-1] + nums[i];
            no_rob[i] = Math.max(rob[i-1], no_rob[i-1]);
        }
        return Math.max(rob[n-1], no_rob[n-1]);
    }

    public int robII(int[] nums) {
        int n = nums.length - 1;
        int[] rob = new int[n];
        int[] no_rob = new int[n];
        rob[0] = nums[0];
        for (int i = 1; i < n; i++) {
            rob[i] = no_rob[i-1] + nums[i];
            no_rob[i] = Math.max(rob[i-1], no_rob[i-1]);
        }
        return Math.max(rob[n-1], no_rob[n-1] + nums[n]);
    }

    @Test
    public void test() {
        int[] nums = {2, 3, 2};
        System.out.println(robII(nums));
    }
}
