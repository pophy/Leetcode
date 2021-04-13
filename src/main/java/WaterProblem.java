import org.testng.annotations.Test;

public class WaterProblem {

    /**
     * 给定一个数组arr，已知其中所有的值都是非负的，
     * 将这个数组看作一个容器，
     * 请返回容器能装多少水 比如，arr = {3，1，2，5，2，4}，
     * 根据值画出的直方图就是容器形状，该容 器可以装下5格水
     * 再比如，arr = {4，5，1，3，2}，该容器可以装下2格水
     */

    private int solution(int[] m) {
        int M = m.length;
        int[] leftMax = new int[M];
        int[] rightMax = new int[M];
        leftMax[0] = m[0];
        for (int i = 1; i < M; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], m[i]);
        }
        rightMax[M-1] = m[M - 1];
        for (int i = M - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], m[i]);
        }
        int max = 0;
        for (int i = 1; i < M - 1; i++) {
            int currentMax = Math.min(leftMax[i], rightMax[i]) - m[i];
            if (currentMax < 0) {
                currentMax = 0;
            }
            max += currentMax;
        }
        return max;
    }

    @Test
    public void test() {
        int[] m = {3,1,2,5,2,4};
        System.out.println(solution(m));
    }

}
