/**
 * Created by Fei on 1/10/2018.
 */
public class PaintFence {

    public int numWays(int n, int k) {
        if (n < 0 || k < 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return  k*k;
        }
        int[] dp = new int[n];
        dp[0] = k;
        dp[1] = k*k;
        for (int i=2;i<n;i++) {
            dp[i] = (k-1)*(dp[i-1] + dp[i-2]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        PaintFence paintFence = new PaintFence();
        paintFence.numWays(1,1);
    }
}
