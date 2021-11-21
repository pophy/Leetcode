package dp;

import org.junit.jupiter.api.Test;

public class StoneGameII {

    int[] suf;

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        suf = new int[n + 1];
        int[][] memo = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suf[i] = suf[i + 1] + piles[i];
        }
        return solve(piles, 0, 1, memo);
    }

    private int solve(int[] piles, int idx, int m, int[][] memo) {
        if (idx == piles.length) {
            return 0;
        }
        if (memo[idx][m] != 0) {
            return memo[idx][m];
        }

        for (int x = 1; x <= 2 * m; x++) {
            if (idx + x - 1 >= piles.length) {
                break;
            }
            memo[idx][m] = Math.max(memo[idx][m], suf[idx] - solve(piles, idx + x, Math.max(x, m), memo));
        }
        return memo[idx][m];
    }

    @Test
    public void test() {
        int[] nums = {2, 7, 9, 4, 4};
        System.out.println(stoneGameII(nums));
    }
}
