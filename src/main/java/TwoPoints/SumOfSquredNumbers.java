package TwoPoints;

import org.junit.jupiter.api.Test;

public class SumOfSquredNumbers {

    /**
     * 判断一个非负整数是否为两个整数的平方和。
     */

    public boolean solution(int K) {
        int l = 0; int r = (int)Math.sqrt(K);
        while (l <= r) {
            if (squre(l) + squre(r) == K) {
                return true;
            } else if (squre(l) + squre(r) > K) {
                r--;
            } else {
                l++;
            }
        }
        return false;
    }

    private int squre(int k) {
        return k * k;
    }

    @Test
    public void test() {
        System.out.println(solution(8));
    }

}
