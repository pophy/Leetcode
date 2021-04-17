import org.junit.jupiter.api.Test;

public class SubMatrixMaxSum {

    /**
     * 请实现一段代码，输入为帖子近期的打分记录，输出为当前帖子 得到的最高分数。
     * [1,1,-1,-10,11,4,-6,9,20,-10,-2]
     */

    public int maxScore(int[] m) {
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m.length; i++) {
            cur = cur + m[i];
            if (cur < 0) {
                cur = 0;
            }
            max = Math.max(max, cur);
        }
        return max;
    }

    /**
     * 给定一个整型矩阵，返回子矩阵的最大累计和。
     */
    public int maxSubMatrixSum(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        int[] s = null;
        for (int i = 0; i < m.length; i++) {
            s = new int[m[0].length];
            for (int j = i; j < m[0].length; j++) {
                for (int k = 0; k < m[0].length; k++) {
                    s[k] += m[j][k];
                    cur += s[k];
                    if (cur < 0) {
                        cur = 0;
                    }
                    max = Math.max(max, cur);
                }
            }
        }
        return max;
    }


    @Test
    public void test() {
        int[] m = {1, 1, -1, -10, 11, 4, -6, 9, 20, -10, -2};
        System.out.println(maxScore(m));
    }

}
