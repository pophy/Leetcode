package binarySearch;

import org.junit.jupiter.api.Test;

public class BinarySearchLeftBoundary {

    public int leftBoundary(int[] m, int K) {
        int l = 0;
        int r = m.length;
        while (l < r) { //左闭右开 结果集： [left,left)
            int mid = (l + r) / 2;
            if (m[mid] == K) {
                r = mid;
            } else if (m[mid] > K) {
                r = mid; //mid检测过 结果集更新为[l,mid)
            } else {
                l = mid + 1; // [mid+1,r)
            }
        }
        return m[l] == K ? l : -1;

    }

    public int rightBoundary(int[] m, int t) {
        int l = 0;
        int r = m.length - 1;
        while (l < r) {
            int mid = r - (r - l) / 2;
            if (m[mid] <= t) {
                l = mid;
            } else if (m[mid] > t) {
                r = mid - 1;
            }
        }
        return l;
    }


    public int searchLeft(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == k) {
                right = mid;
            } else if (nums[mid] > k) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums[left] == k) return left;
        if (nums[right] == k) return right;
        return -1;
    }

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

    public int[] searchRange(int[] A, int target) {
        return new int[]{searchLeft(A, target), searchRight(A, target)};
    }


    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }


    @Test
    public void test() {
        int[] m = {1, 3, 3, 5, 6};
        System.out.println(rightBoundary(m, 5));

    }

}
