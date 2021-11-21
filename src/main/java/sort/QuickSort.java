package sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class QuickSort {

    public void sort(int[] nums) {
        helper(nums, 0, nums.length - 1);
    }

    private void helper(int[] nums, int start, int end) {
        if (start == end) {
            return;
        }
        int k = partition(nums, start, end);
        if (k - 1 > start) {
            helper(nums, start, k - 1);
        }
        if (k + 1 < end) {
            helper(nums, k + 1, end);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = start;
        int l = start + 1;
        int r = end;
        while (l <= r) {
            if (nums[l] > nums[pivot] && nums[r] < nums[pivot]) {
                swap(nums, l, r);
                l++;
                r--;
            }
            if (nums[l] <= nums[pivot]) {
                l++;
            }
            if (nums[r] >= nums[pivot]) {
                r--;
            }
            System.out.println("l:" + l + " r: " + r);
        }
        System.out.println("---------------------");
        swap(nums, pivot, r);
        System.out.println("++++++++++++++++++++++");
        return r;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test() {
        int[] nums = {3, 1, 2, 6, 4, 7};
        sort(nums);
        Arrays.stream(nums).forEach(n -> {
            System.out.println(n);
        });
    }

}
