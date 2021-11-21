package dp;

import org.junit.jupiter.api.Test;

public class StoneGameIV {

    Boolean[] memo;

    public boolean winnerSquareGame(int n) {
        memo = new Boolean[n + 1];
        return solve(n);
    }

    private boolean solve(int n) {
        if (n <= 0) {
            return false;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        for (int i = 1; i * i <= n; i++) {
            if (!solve(n - i * i)) {
                memo[n] = true;
                return true;
            }
        }
        memo[n] = false;
        return false;
    }

    @Test
    public void test() {
        System.out.println(winnerSquareGame(17));
    }

}
