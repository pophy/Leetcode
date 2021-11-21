package dp.knapsack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        int max = amount + 1;
        Arrays.fill(dp[0], max);//with 0 coin, not possible

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                int coin = coins[i-1];
                dp[i][j] = dp[i-1][j];
                if (j - coin >= 0 && dp[i][j - coin] != max) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - coin] + 1);
                }
            }
        }
        return dp[n][amount] == max ? -1 : dp[n][amount] ;
    }

    @Test
    public void test() {
        int[] coins = {1,2, 5};
        System.out.println(coinChange(coins, 11));
    }
}
