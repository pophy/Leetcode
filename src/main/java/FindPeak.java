/**
 * Created by Fei on 2/4/2018.
 */
public class FindPeak {

    public int findPeak(int[] A) {
        int start = 0; int end = A.length;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {
                return mid;
            } else if (A[mid - 1] < A[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        int[] ds = {1,2,1,3,4,5,7,6};
        FindPeak findPeak = new FindPeak();
        findPeak.findPeak(ds);
    }
}
