package dp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StoneGameIII {
    int[] suf;

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        suf = new int[n + 1];
        int[] memo = new int[n + 1];
        Arrays.fill(memo,Integer.MIN_VALUE);
        for (int i = n - 1; i >= 0; i--) {
            suf[i] = suf[i + 1] + stoneValue[i];
        }
        int score = solve(stoneValue, 0, memo);
        if (score > suf[0] - score) {
            return "Alice";
        } else if (score < suf[0] - score) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    private int solve(int[] piles, int idx, int[] memo) {
        if (idx == piles.length) {
            return 0;
        }
        if (memo[idx] != Integer.MIN_VALUE) {
            return memo[idx];
        }

        for (int x = 1; x <= 3; x++) {
            if (idx + x - 1 >= piles.length) {
                break;
            }
            memo[idx] = Math.max(memo[idx], suf[idx] - solve(piles, idx + x, memo));
        }
        return memo[idx];
    }

    @Test
    public void test() {
        int[] nums = {-1, -2, -3};
        System.out.println(stoneGameIII(nums));
    }

}
