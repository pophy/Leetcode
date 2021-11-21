package binarySearch;

import org.junit.jupiter.api.Test;

public class FindMinInRotateArray {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            if (nums[left] <= nums[right]) {
                return nums[left];
            }
            int mid = left + (right - left) / 2;
            if (nums[left] <= nums[mid]) {
                left = mid;
            } else if (nums[mid] <= nums[right]) {
                right = mid;
            }
        }
        return nums[left] < nums[right] ? nums[left] : nums[right];
    }

    @Test
    public void test() {
        int[] nums = {3,4,5,1,2};
        System.out.println(findMin(nums));
    }

}
