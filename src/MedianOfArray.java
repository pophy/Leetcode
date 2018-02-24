/**
 * Created by Fei on 2/4/2018.
 */
public class MedianOfArray {

    public double findMedianSortedArraysTT(int[] a, int[] b) {

        if (a == null && b == null) {
            return -1;
        }
        if (a == null || a.length == 0) {
            return getMidian(b);
        }
        if (b == null || b.length == 0) {
            return getMidian(a);
        }

        if (a.length > b.length) {
            return findMedianSortedArraysTT(b, a);
        }
        int m = a.length;
        int n = b.length;
        int length = (m + n);
        int cutL = 0;
        int cutR = m;
        int cut = 0;

        while (cut >= 0) {
            cut = (cutR - cutL)/2 + cutL;
            int cut2 = (length + 1)/2 - cut;
            double l1 = cut == 0 ? Integer.MIN_VALUE : a[cut - 1];
            double r1 = cut == m - 1? Integer.MAX_VALUE : a[cut];
            double l2 = cut2 == 0 ? Integer.MIN_VALUE : b[cut2 - 1];
            double r2 = cut2 == n  ? Integer.MAX_VALUE : b[cut2];
            if (l1 <= r2 && l2 <= r1) {
                if (length%2 == 0) {
                    double l = Math.max(l1,l2);
                    double r = Math.min(r1,r2);
                    System.out.println((l + r)/2);
                    return (l + r)/2;
                } else {
                    return Math.min(l2,r2);
                }
            } else if (l1 > r2) {
                cutR = cut;
            } else {
                cutL = cut;
            }
        }
        return -1;
    }

    public double findMedianSortedArrays1(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        // make sure m <= n
        if (m > n) return findMedianSortedArrays1(B, A);

        int imin = 0, imax = m;
        while (imin <= imax) {
            int i = imin + (imax - imin) / 2;
            int j = (m + n + 1) / 2 - i;

            int A_left = i == 0 ? Integer.MIN_VALUE : A[i - 1];
            int A_right = i == m ? Integer.MAX_VALUE : A[i];
            int B_left = j == 0 ? Integer.MIN_VALUE : B[j - 1];
            int B_right = j == n ? Integer.MAX_VALUE : B[j];

            if (A_left > B_right) {
                imax = i - 1;
            } else if (B_left > A_right) {
                imin = i + 1;
            } else {
                int max_left = A_left > B_left ? A_left : B_left;
                int min_right = A_right > B_right ? B_right : A_right;
                if ((m + n) % 2 == 1)
                    return max_left; // # of left_part = # of right_part + 1;
                else
                    return (max_left + min_right) / 2.0;
            }
        }
        return -1;
    }

    private double getMidian(int[] nums) {
        int mid = nums.length/2;
        if (nums.length%2 == 0 && mid > 0) {
            double n1 = nums[mid - 1];
            double n2 = nums[mid];
            return (n1 + n2)/2;
        } else {
            return nums[mid];
        }
    }

    public static void main(String[] args) {
        MedianOfArray medianOfArray = new MedianOfArray();
        int[] a = {1};
        int[] b = {};
        medianOfArray.findMedianSortedArrays1(a,b);
    }


}
