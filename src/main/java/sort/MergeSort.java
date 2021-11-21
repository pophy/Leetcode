package sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MergeSort {

    public void sort(int[] nums) {
        helper(nums, 0, nums.length - 1);
    }

    private void helper(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        //divide
        int mid = start + (end - start) / 2;
        helper(nums, start, mid);
        helper(nums, mid + 1, end);
        //merge
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[nums.length];
        int curIndex = start;
        int leftIndex = start;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= end) {
            if (nums[leftIndex] <= nums[rightIndex]) {
                temp[curIndex] = nums[leftIndex];
                curIndex++;
                leftIndex++;
            } else {
                temp[curIndex] = nums[rightIndex];
                curIndex++;
                rightIndex++;
            }
        }
        while (leftIndex <= mid) {
            temp[curIndex] = nums[leftIndex];
            curIndex++;
            leftIndex++;
        }
        while (rightIndex <= end) {
            temp[curIndex] = nums[rightIndex];
            curIndex++;
            rightIndex++;
        }
        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
    }

    @Test
    public void test() {
        int[] nums = {3,7,4,1,2,9};
        sort(nums);
        Arrays.stream(nums).forEach(n -> {
            System.out.println(n);
        });
    }

}
