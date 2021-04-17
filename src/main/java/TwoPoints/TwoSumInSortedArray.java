package TwoPoints;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TwoSumInSortedArray {

    /**
     * 题目描述：在有序数组中找出两个数，使它们的和为 target。
     */

    public int[] solution(int[] m, int target) {
        if (m == null && m.length == 0) {
            return null;
        }
        int l = 0;
        int r = m.length - 1;
        while (l < r) {
            if (m[l] + m[r] == target) {
                int[] res = new int[2];
                res[0] = l;
                res[1] = r;
                return res;
            } else if (m[l] + m[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return null;
    }

    @Test
    public void test() {
        int[] m = {1,3,5,6,7,9};
        Arrays.stream(solution(m,11)).forEach(p->{
            System.out.println(p);
        });
    }

}
