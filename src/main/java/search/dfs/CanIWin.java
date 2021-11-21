package search.dfs;

import org.junit.jupiter.api.Test;

public class CanIWin {

    int[] memo = new int[1 << 21];

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sumTotal = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sumTotal < desiredTotal) {
            return false;
        }
        return dfs(0, 0, maxChoosableInteger, desiredTotal);
    }

    private boolean dfs(int state, int sum, int maxChoosableInteger, int desiredTotal) {
        System.out.println(state);
        if (memo[state] == 2) {
            return true;
        }
        if (memo[state] == 1) {
            return false;
        }
        for (int i = 1; i <= maxChoosableInteger; i++) {
            if (((state >> i) & 1) == 1) {
                continue;
            }
            if (sum + i >= desiredTotal) {
                memo[state] = 2;
                return true;
            }
            if (!dfs(state + (1 << i), sum + i, maxChoosableInteger, desiredTotal)) {
                memo[state] = 2;
                return true;
            }
        }
        memo[state] = 1;
        return false;
    }

    @Test
    public void test() {
        System.out.println(canIWin(10, 25));
    }

}
