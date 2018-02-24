/**
 * Created by Fei on 2/13/2018.
 */
public class HouseRobber {
    public long houseRobber(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] dp = new int[n + 1];
        boolean[] robbed = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (robbed[i - 1]) {
                dp[i] = dp[i - 1];
            } else {
                if (dp[i - 1] + A[i - 1] > dp[i]) {
                    dp[i] = dp[i - 1] + A[i - 1];
                    robbed[i] = true;
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        int[] ds = {3,8,4};
        houseRobber.houseRobber(ds);
    }
}
