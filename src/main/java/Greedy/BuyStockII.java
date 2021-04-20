package Greedy;

import org.junit.jupiter.api.Test;

public class BuyStockII {

    public int buyStock(int[] m) {
        int profit = 0;
        for (int i = 1; i < m.length; i++) {
            int currentProfit = m[i] > m[i - 1] ? m[i] - m[i - 1] : 0;
            profit+=currentProfit;
        }
        return profit;
    }

    @Test
    public void test() {
        int[] m = {1,3,5,4,3,5,3};
        System.out.println(buyStock(m));
    }
}
