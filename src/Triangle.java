/**
 * Created by Fei on 1/9/2018.
 */
public class Triangle {

    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }

        int n = triangle.length;
        int[][] sum = new int[n][n];

        sum[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            sum[i][0] = sum[i - 1][0] + triangle[i][0];
            sum[i][i] = sum[i - 1][i - 1] + triangle[i][i];
        }

        for (int i=1;i<n;i++) {
            for (int j=i;j<n;j++) {
                sum[i][j] = Math.min(sum[i-1][j-1],sum[i][j-1]) + triangle[i][j];
            }
        }

        int minPath = Integer.MAX_VALUE;
        for (int i=0;i<n;i++) {
            minPath = Math.min(minPath,sum[n-1][i]);
        }

        return minPath;

    }
}
