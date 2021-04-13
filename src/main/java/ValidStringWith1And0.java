import org.testng.annotations.Test;

public class ValidStringWith1And0 {

    /**
     * 字符串只由'0'和'1'两种字符构成， 当字符串长度为1时，所有可能的字符串为"0"、"1"；
     * 当字符串长度为2时，所有可能的字符串为"00"、"01"、"10"、"11"；
     * 当字符串长度为3时，所有可能的字符串为"000"、"001"、"010"、"011"、"100"、 "101"、"110"、"111" ...
     *
     * 如果某一个字符串中，只要是出现'0'的位置，左边就靠着'1'，这样的字符串叫作达 标字符串。
     * 给定一个正数N，返回所有长度为N的字符串中，达标字符串的数量。 比如，N=3，返回3，因为只有"101"、"110"、"111"达标。
     */

    public int solution(int n) {
        int[] cache = new int[n + 1];
        return validStringNumber(n, cache);
    }

    public int validStringNumber(int n, int[] cache) {
        if (n == 0) {
            cache[n] = 0;
            return 0;
        }
        if (n == 1) {
            cache[1] = 1;
            return 1;
        }
        if (n == 2) {
            cache[2] = 2;
            return 2;
        }
        cache[n] = validStringNumber(n - 1, cache) + validStringNumber(n - 2, cache);
        return cache[n];
    }

    private int solutionDP(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    @Test
    public void test() {
        System.out.println(solution(8));
        System.out.println(solutionDP(8));
    }

}
