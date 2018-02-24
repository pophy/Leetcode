/**
 * Created by Fei on 1/9/2018.
 */
public class MinPath {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] minSum = new int[m][n];
        minSum[m-1][n-1] = grid[m-1][n-1];

        for (int i=m-2;i>=0;i--) {
            minSum[i][n-1] = minSum[i+1][n-1] + grid[i][n-1];
        }
        for (int i=n-2;i>=0;i--) {
            minSum[m-1][i] = minSum[m-1][i+1] + grid[m-1][i];
        }
        for (int i=m-2;i>=0;i--) {
            for (int j=n-2;j>=0;j-- ) {
                minSum[i][j] = Math.min(minSum[i+1][j],minSum[i][j+1]) + grid[i][j];
            }
        }

        return minSum[0][0];

    }

    public static void main(String[] args) {
        int[][] data = new int[2][2];
        data[0] = new int[]{1,2};
        data[1] = new int[]{2,1};
        MinPath minPath = new MinPath();
        minPath.minPathSum(data);
    }
}
