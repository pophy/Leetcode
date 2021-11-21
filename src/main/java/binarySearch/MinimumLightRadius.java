package binarySearch;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MinimumLightRadius {

    public double solve(int[] nums) {
        Arrays.sort(nums);
        int streetLength = nums[nums.length - 1] - nums[0];
        int low = 0, high = streetLength / 3 + 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (isPossible(nums, mid, 3)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        if (isPossible(nums, low, 3)) {
            return low / 2D;
        }
        return high / 2D;
    }

    private boolean isPossible(int[] nums, int radius, int lightNumber) {
        int lightRadius = -1;
        int currentLightNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > lightRadius) {
                currentLightNum++;
                lightRadius = nums[i] + radius;
            }
            if (currentLightNum > lightNumber) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[] nums = {0, 1, 2, 3};
        System.out.println(solve(nums));
    }

}
