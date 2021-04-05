/**
 * Created by Fei on 2/6/2018.
 */
public class JumpGame2 {

    public int jump(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int n = a.length;
        int[] dp = new int[n];

        boolean[] canJump = new boolean[n];
        canJump[0] = true;
        for (int i=1;i<n;i++) {
            for (int j=0;j<i;j++) {
                if (canJump[j] && i - j <= a[j]) {
                    canJump[i] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int minStep = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                if (canJump[j] && j - i <= a[j]) {
                    minStep = Math.min(minStep,dp[j]);
                }
            }
            dp[i] = minStep + 1;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        JumpGame2 game = new JumpGame2();
        int[] ds = {17,8,29,17,35,28,14,2,45,8,6,54,24,43,20,14,33,31,27,11};
        game.jump(ds);
    }
}
