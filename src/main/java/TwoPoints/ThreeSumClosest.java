package TwoPoints;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length <= 3) {
            return Arrays.stream(nums).sum();
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int currentThreeSum = twoSumClosest(nums, target - nums[i], i) + nums[i];
            if (Math.abs(currentThreeSum - target) < min) {
                min = Math.abs(currentThreeSum - target);
                res = currentThreeSum;
            }
        }
        return res;
    }


    private int twoSumClosest(int[] nums, int target, int excludeIndex) {
        int l = 0, r = nums.length - 1;
        int min = Integer.MAX_VALUE;
        int res = 0;
        while (l < r) {
            if (l == excludeIndex) {
                l++;
                continue;
            }
            if (r == excludeIndex) {
                r--;
                continue;
            }
            int sum = nums[l] + nums[r];
            if (Math.abs(sum - target) < min) {
                min = Math.abs(sum - target);
                res = sum;
            }
            if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 1, 0};
        System.out.println(threeSumClosest(nums, -100));
    }

}
