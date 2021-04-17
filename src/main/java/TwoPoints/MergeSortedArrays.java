package TwoPoints;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 题目描述：把归并结果存到第一个数组上
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 */
public class MergeSortedArrays {

    public int[] merge(int[] arr1, int[] arr2, int m, int n) {
        int l = m - 1;
        int r = n - 1;
        int k = arr1.length - 1;
        while (l >= 0 && r >= 0) {
            if (arr1[l] > arr2[r]) {
                arr1[k] = arr1[l];
                l--;
            } else {
                arr1[k] = arr2[r];
                r--;
            }
            k--;
        }
        while (l >= 0) {
            arr1[k--] = arr1[l--];
        }
        while (r >= 0) {
            arr1[k--] = arr1[r--];
        }
        return arr1;
    }


    @Test
    public void test() {
        int[] nums1 = {1,3,5,0,0,0};
        int[] nums2 = {2,4,6};
        Arrays.stream(merge(nums1,nums2,3,3)).forEach(n -> {
            System.out.print(n+ " ");
        });
    }


}
