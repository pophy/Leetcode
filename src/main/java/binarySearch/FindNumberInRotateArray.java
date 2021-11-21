package binarySearch;

import org.junit.jupiter.api.Test;

public class FindNumberInRotateArray {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[l] < nums[mid]) {
                if (nums[l] <= target && target <= nums[mid]) {
                    r = mid;
                } else {
                    l = mid;
                }
            } else {
                if (nums[mid] <= target && target <= nums[r]) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
        }
        if (nums[l] == target) return l;
        if (nums[r] == target) return r;
        return -1;
    }


    public boolean searchWithDup(int[] nums, int target) {
        if (nums == null) {
            return false;
        }
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[left]) {
                left++;
                continue;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (nums[left] == target || nums[right] == target) {
            return true;
        }
        return false;
    }


    @Test
    public void test() {
        int[] nums = {1,0,1,1,1};
        System.out.println(searchWithDup(nums, 0));
    }
}
