package dp;

import org.junit.jupiter.api.Test;

public class HouseRobII {

    public int rob(int[] nums) {
        int[] n1 = new int[nums.length - 1]; // 0 ~ n-1
        int[] n2 = new int[nums.length - 1]; // 1 ~ n
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1) {
                n1[i] = nums[i];
            }
            if (i > 0) {
                n2[i - 1] = nums[i];
            }
        }
        return Math.max(robHelper(n1), robHelper(n2));
    }


    public int robHelper(int[] nums) {
        int n = nums.length;
        int[] rob = new int[n];
        int[] no_rob = new int[n];
        rob[0] = nums[0];
        for (int i = 1; i < n; i++) {
            rob[i] = no_rob[i - 1] + nums[i];
            no_rob[i] = Math.max(rob[i - 1], no_rob[i - 1]);
        }
        return Math.max(rob[n - 1], no_rob[n - 1]);
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4};
        System.out.println(rob(nums));
    }

}
