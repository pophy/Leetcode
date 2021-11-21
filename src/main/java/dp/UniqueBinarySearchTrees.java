package dp;

import org.junit.jupiter.api.Test;

public class UniqueBinarySearchTrees {

    int[][] memo;

    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return helper(1, n);
    }


    private int helper(int start, int end) {
        if (start < 0 || start > end || start == end) {
            return 1;
        }
        if (memo[start][end] != 0) {
            return memo[start][end];
        }
        int count = 0;
        for (int i = start; i <= end; i++) {
            count += helper(start, i - 1) * helper(i + 1, end);
        }
        return memo[start][end] = count;
    }

    @Test
    public void test() {
        System.out.println(numTrees(3));
    }

}
