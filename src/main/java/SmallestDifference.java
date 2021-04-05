import java.util.Arrays;

/**
 * Created by Fei on 2/13/2018.
 */
public class SmallestDifference {
    public int smallestDifference(int[] A, int[] B) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            int diff = A[i] - B[j];
            result = Math.min(result,Math.abs(diff));
            if (diff == 0) {
                return 0;
            } else if (diff > 0) {
                j++;
            } else {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SmallestDifference smallestDifference = new SmallestDifference();
        int[] ds1 = {2147483647};
        int[] ds2 = {0};
        smallestDifference.smallestDifference(ds1,ds2);
    }
}
