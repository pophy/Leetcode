package Greedy;

public class MaximumSubarray {

    public int solution(int[] m) {
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < m.length; i++) {
             cur = m[i] + cur;
             if (cur < 0) {
                 cur = 0;
             }
             max = Math.max(max,cur);
        }
        return max;
    }
}
