/**
 * Created by Fei on 2/9/2018.
 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int[] fullNums = new int[nums.length + 2];
        fullNums[0] = 1;
        fullNums[fullNums.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            fullNums[i + 1] = nums[i];
        }
        int[][] dp = new int[fullNums.length][fullNums.length];
        return calculateCoin(fullNums,1,fullNums.length - 2,dp);
    }

    private int calculateCoin(int[] fullNums, int start, int end, int[][] dp) {
        if (start < end) {
            return 0;
        }
        for (int i = start; i <= end; i ++) {
            int leftCoin = calculateCoin(fullNums,start, i - 1,dp);
            int rightCoin = calculateCoin(fullNums,i + 1, end,dp);
            int midCoin = fullNums[start - 1] * fullNums[i] * fullNums[end + 1];
            int coin = leftCoin + rightCoin + midCoin;
            dp[start][end] = Math.max(dp[start][end],coin);
        }
        return dp[start][end];

    }

    public static void main(String[] args) {
        BurstBalloons balloons = new BurstBalloons();
        int[] ds = {4,1,5,10};
        balloons.maxCoins(ds);
    }

    private class TestItem {
        String word;

        @Override
        public boolean equals(Object o) {

            TestItem testItem = (TestItem) o;
            if (word.length() != ((TestItem) o).word.length()) {
                return false;
            }
            int[] dict = new int[26];
            for (int i = 0; i < word.length(); i++) {
                dict[word.charAt(i) - 'a']++;
            }
            for (int i = 0; i < testItem.word.length(); i++) {
                dict[testItem.word.charAt(i) - 'a']--;
                if (dict[testItem.word.charAt(i) - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }

    }
}
