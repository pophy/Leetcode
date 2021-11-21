package dp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LongestIncresingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int res = 1;
        for (int r : dp) {
            res = Math.max(r, res);
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {4, 10, 4, 3, 8, 9};
        System.out.println(lengthOfLIS(nums));
    }
}
