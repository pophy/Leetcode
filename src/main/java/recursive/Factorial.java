package recursive;

import org.junit.jupiter.api.Test;

public class Factorial {

    long[] memo = new long[100];

    public long getFactorial(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        long res = getFactorial(n-1) * n;
        memo[n] = res;
        return res;
    }

    @Test
    public void test() {
        long past = System.nanoTime();
        System.out.println(getFactorial(30));
        long current = System.nanoTime();
        System.out.println("time used: " + (current - past));

    }
}
