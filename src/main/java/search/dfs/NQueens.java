package search.dfs;

import org.junit.jupiter.api.Test;

public class NQueens {

    public int totalNQueens(int n) {
        int[] memo = new int[n];
        return dfs(n, 0, memo);
    }

    private int dfs(int n, int row, int[] memo) {
        if (row == n) {
            return 1;
        }
        int res = 0;
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, memo)) {
                memo[row] = col;
                res += dfs(n, row + 1, memo);
            }
        }
        return res;
    }

    private boolean isValid(int row, int col, int[] memo) {
        for (int k = 0; k < row; k++) {
            if (col == memo[k] || Math.abs(memo[k] - col) == Math.abs(k - row)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(totalNQueens(3));
    }
}
