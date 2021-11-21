package TwoPoints;

import org.junit.jupiter.api.Test;

public class NumberOperationsDecrementTargetZero {

    public int solve(int[] nums, int target) {
        int sum = -target;
        for (int n : nums) {
            sum += n;
        }
        if (sum < 0) {
            return -1;
        }
        if (sum == 0) {
            return nums.length;
        }
        int l = 0, maxLength = Integer.MIN_VALUE, subTotal = 0;
        for (int i = 0;i < nums.length; i++) {
            subTotal += nums[i];
            while (subTotal > sum) {
                subTotal -= nums[l++];
            }
            if (subTotal == sum) {
                maxLength = Math.max(maxLength, i - l + 1);
            }
        }
        if (maxLength == Integer.MIN_VALUE) {
            return -1;
        }
        return nums.length - maxLength;
    }

    @Test
    public void test() {
        int[] nums = {1};
        System.out.println(solve(nums,1));
    }
}
