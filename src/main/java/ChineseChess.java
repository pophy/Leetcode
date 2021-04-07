import org.testng.annotations.Test;

public class ChineseChess {

    public int countOfWays(int x, int y, int k) { // k steps to point(x,y)
        int[][][] cache = new int[9][10][k + 1];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 10; j++) {
                for (int l = 0; l < k + 1; l++) {
                    cache[i][j][l] = -1;
                }
            }
        }

        return process(x, y, k, cache);
    }

    private int process(int x, int y, int step, int[][][] cache) {  //return count of ways to move from point(0,0) to point(x,y)
        if (x < 0 || x > 8 || y < 0 || y > 9) {
            return 0;
        }
        if (step == 0) {
            if (x == 0 && y == 0) {
                cache[x][y][step] = 1;
                return 1;
            }
            cache[x][y][step] = 0;
            return 0;
        }
        if (cache[x][y][step] != -1) {
            return cache[x][y][step];
        }
        cache[x][y][step] =
                process(x - 1, y + 2, step - 1, cache)
                        + process(x + 1, y + 2, step - 1, cache)
                        + process(x + 2, y + 1, step - 1, cache)
                        + process(x + 2, y - 1, step - 1, cache)
                        + process(x + 1, y - 2, step - 1, cache)
                        + process(x - 1, y - 2, step - 1, cache)
                        + process(x - 2, y - 1, step - 1, cache)
                        + process(x - 2, y + 1, step - 1, cache);

        return cache[x][y][step];
    }

    public int countDP(int x, int y, int step) {
        int[][][] dp = new int[9][10][step + 1];
        dp[0][0][0] = 1;


        return dp[x][y][step];
    }


    //===================================>


    @Test
    public void test() {
        System.out.println(countOfWays(4, 5, 3));
    }

}
