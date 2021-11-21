package binarySearch;

import org.junit.jupiter.api.Test;

public class BinarySearchRightBoundary {

    public int searchRight(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == k) {
                left = mid;
            } else if (nums[mid] > k) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums[right] == k) return right;
        if (nums[left] == k) return left;
        return -1;
    }

    @Test
    public void test() {
        int[] m = {1,1,1};
        System.out.println(searchRight(m, 1));
    }
}
