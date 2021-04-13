import org.testng.annotations.Test;

public class MinPathSumInMatrix {

    public int minPathSum(int[][] m) {
        int M = m.length - 1;
        int N = m[0].length - 1;
        return process(m, M, N);
    }

    private int process(int[][] m, int i, int j) {
        if (i == 0 && j == 0) {
            return m[i][j];
        }
        if (i == 0) {
            return process(m, i, j - 1) + m[i][j];
        }
        if (j == 0) {
            return process(m, i - 1, j) + m[i][j];
        }
        return Math.min(process(m, i - 1, j), process(m, i, j - 1)) + m[i][j];
    }

    private int minDP(int[][] m) {
        int M = m.length;
        int N = m[0].length;
        int[][] dp = new int[M][N];
        dp[0][0] = m[0][0];
        for (int i = 1; i < M; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int i = 1; i < M; i++) {
            dp[0][i] = dp[0][i - 1] + m[0][i];
        }
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[M - 1][N - 1];
    }

    @Test
    public void test() {
        int[][] m = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1},
                {8, 8, 4, 0}};
        System.out.println(minDP(m));
        System.out.println(minPathSum(m));
    }

}
