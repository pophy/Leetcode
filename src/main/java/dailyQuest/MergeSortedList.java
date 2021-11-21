package dailyQuest;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 */

public class MergeSortedList {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int cur = m + n - 1;

        while (i >=0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[cur] = nums1[i];
                i--;
                cur--;
            } else {
                nums1[cur] = nums2[j];
                j--;
                cur--;
            }
        }
        while (j >= 0) {
            nums1[cur] = nums2[j];
            j--;
            cur--;
        }

    }



}
