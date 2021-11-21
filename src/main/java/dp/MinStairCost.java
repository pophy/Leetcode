package dp;

import org.junit.jupiter.api.Test;

public class MinStairCost {

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        return dp[dp.length - 1];
    }

    @Test
    public void test() {
        int[] cost = {10, 15, 20};
        System.out.println(minCostClimbingStairs(cost));
    }
}
