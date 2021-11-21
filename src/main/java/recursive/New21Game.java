package recursive;

import org.junit.jupiter.api.Test;

public class New21Game {

//    public double new21Game(int n, int k, int maxPts) {
//        return dfs(n, k, maxPts, 0);
//    }
//
//    private double dfs(int n, int k, int maxPts, int currentTotal) {
//        if (currentTotal >= k) {
//            if (currentTotal <= n) {
//                return 1D;
//            }
//            return 0;
//        }
//        double probability  = 0;
//        for (int i = 1; i <= maxPts; i++) {
//            probability += dfs(n, k, maxPts, currentTotal + i) * (1D / maxPts);
//        }
//        return probability ;
//    }

//    public double new21Game(int n, int k, int maxPts) {
//        double[] dp = new double[n + 1];
//        dp[0] = 1D;
//        for (int i = 1; i <= n; i++) {
//            for (int j = i - maxPts; j <= i - 1; j++) {
//                if (j < 0) {
//                    continue;
//                }
//                if (j >= k) {
//                    continue;
//                }
//                dp[i] += dp[j] * (1D / maxPts);
//                System.out.println("i = " + i + " dp: " + dp[i]);
//            }
//        }
//        double res = 0;
//        for (int i = k; i <= n; i++) {
//            res += dp[i];
//        }
//        return res;
//    }

    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k + maxPts - 1) {
            return 1.0;
        }
        double[] dp = new double[k + maxPts];
        dp[0] = 1D;
        double sum = 1.0;

        //dp[i] = (dp[i-1] + dp[i-2] + ... + dp[i-maxPts]) * 1/maxPts
        for (int i = 1; i < k + maxPts; i++) {
            dp[i] = sum * 1D / maxPts;
            if (i < k) {
                sum += dp[i];
            }
            if (i - maxPts >= 0) {
                sum -= dp[i - maxPts];
            }
        }
        double res = 0;
        for (int i = k; i <= n; i++) {
            res += dp[i];
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(new21Game(185, 183, 2));
    }
}
