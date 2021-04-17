package binarySearch;

import org.junit.jupiter.api.Test;

public class BinarySearchRightBoundary {

    public int leftBoundary(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) { //左闭右开 结果集： [left,left)
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 注意
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return nums[left - 1] == target ? nums[left - 1] : -1;

    }

    @Test
    public void test() {
        int[] m = {1, 2, 3, 4, 4, 5, 5, 6, 7};
        System.out.println(leftBoundary(m, 5));
    }
}
