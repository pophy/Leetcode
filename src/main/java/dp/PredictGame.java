package dp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PredictGame {

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        Integer[][] memo = new Integer[n][n];
        return dfs(nums, 0, n-1, memo) >= 0;

    }

    private int dfs(int[] nums, int l, int r, Integer[][] memo) {
        if (l > r)
            return 0;
        if (memo[l][r] != null)
            return memo[l][r];

        memo[l][r] = Math.max(nums[l] - dfs(nums, l + 1, r, memo),
                nums[r] - dfs(nums, l, r - 1, memo));
        return memo[l][r];

    }

    @Test
    public void test() {
        int[] nums = {1,5,2};
        System.out.println(predictTheWinner(nums));
    }

}
