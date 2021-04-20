package dp;

import org.junit.jupiter.api.Test;

public class BuyStockWithCD {

    public static int maxProfit(int[] m) {
        int num = process(m, 0, false);
        return num;
    }

    private static int process(int[] m, int index, boolean sell) {
        if (index >= m.length) {
            return 0;
        }
        int a = 0, b = 0, c = 0;
        //hold
        a = process(m, index + 1, sell);
        if (sell) { //sell
            b = process(m, index + 2, false) + m[index];
        } else { // buy
            c = process(m, index + 1, true) - m[index];        }
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        int[] m = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(m));
    }

}
