import org.testng.annotations.Test;

public class MaxPointInRope {

    //#1##45#7#9
    //

    public int getMaxPoint(int[] m, int K) {
        int maxCount = 0;
        int l = 0;
        int r = 0;
        while (l < m.length) {
            while (r < m.length && m[r] - m[l] >= K) {
                r++;
            }
            maxCount = Math.max(maxCount, l - r);
            l++;
        }
        return maxCount;
    }



    @Test
    public void test() {
        int[] arr = { 0, 13, 24, 35, 46, 57, 60, 72, 87 };
        System.out.println(getMaxPoint(arr,7));
    }
}
