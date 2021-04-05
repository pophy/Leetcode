public class DecoyWays {


    int[] v = new int[100];

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return dfs(s.toCharArray(), 0);

    }

    private int dfs(char[] chars, int index) {
        if (index >= chars.length) {
            return 1;
        }
        if (chars[index] == '0') {
            return 0;
        }

        if (v[index] != 0) {
            return v[index];
        }
        int count = dfs(chars, index + 1);
        if (index + 1 < chars.length) {
            int currentDigit = chars[index] - '0';
            int nextDigit = chars[index + 1] - '0';
            if (currentDigit * 10 + nextDigit <= 26) {
                count += dfs(chars, index + 2);
            }
        }
        v[index] = count;
        return count;
    }

    public static void main(String[] args) {
        DecoyWays decoyWays = new DecoyWays();
        decoyWays.numDecodings("10");
    }
}
