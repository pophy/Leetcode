package binarySearch;

import org.junit.jupiter.api.Test;

public class KthSmallestSubarraySum {

    public int solve(int[] nums, int k) {
        int[] psum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            psum[i + 1] = psum[i] + nums[i];
        }
        int lower = 0, upper = psum[psum.length - 1];
        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;
            int count = countLessOrEqulas(psum, mid);
            if (count < k) {
                lower = mid + 1;
            } else {
                upper = mid;
            }
        }
        return lower;
    }

    private int countLessOrEqulas(int[] psum, int target) {
        int count = 0;
        for (int i = 0; i < psum.length; i++) {
            int pos = findUpperBound(psum, psum[i] + target, i);
            count += pos - i - 1;
        }
        return count;
    }

    private int findUpperBound(int[] psum, int key, int startIndex) {
        if (key > psum[psum.length - 1]) {
            return psum.length;
        }
        int lower = startIndex, upper = psum.length - 1;
        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;
            if (psum[mid] < key) {
                lower = mid + 1;
            } else {
                upper = mid;
            }
        }
        return lower;
    }

    @Test
    public void test() {
        int[] nums = {2, 1, 3};
        System.out.println(solve(nums, 4));
    }

}
