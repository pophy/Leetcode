package binarySearch;

import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class KthPairDistance {

    public int solve(int[] nums, int k) {
        k += 1;
        Arrays.sort(nums);
        int low = Integer.MAX_VALUE, high = nums[nums.length - 1] - nums[0];
        for (int i = 1; i < nums.length; i++) {
            low = Math.min(low, nums[i] - nums[i - 1]);
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countPairs(nums, mid);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int countPairs(int[] nums, int mid) {
        int n = nums.length, res = 0;
        for (int i = 0; i < n; i++) {
            res += upperBound(nums, i, n - 1, nums[i] + mid) - i - 1;
        }
        return res;
    }

    private int upperBound(int[] a, int low, int high, int key) {
        if (a[high] <= key) return high + 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (key >= a[mid]) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (a[low] > key) {
            return low;
        }
        return high;
    }
}
