import org.testng.annotations.Test;

public class MoneyChange {

    public int leastCoin(int[] coins, int aim) {
        int[][] cache = new int[coins.length + 1][aim + 1];
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[0].length; j++) {
                cache[i][j] = -1;
            }
        }
        return process(coins, 0, aim, cache);
    }

    private int process(int[] coins, int index, int remaining, int[][] cache) {
        if (remaining < 0) {
            return -1;
        }
        if (index == coins.length) {
            cache[index][remaining] = remaining == 0 ? 0 : -1;
        } else {
            int res = -1;
            int coin = coins[index];
            for (int numberOfCoins = 0; numberOfCoins * coin <= remaining; numberOfCoins++) {
                int next = process(coins, index + 1, remaining - numberOfCoins * coin, cache);
                if (next != -1) {
                    if (res == -1) {
                        res = next + numberOfCoins;
                    } else {
                        res = Math.min(res, numberOfCoins + next);
                    }
                }
            }
            cache[index][remaining] = res;
        }
        return cache[index][remaining];
    }

    @Test
    public void test() {
        int[] m = {2, 3, 5};
        System.out.println(leastCoin(m, 10));
    }
}
