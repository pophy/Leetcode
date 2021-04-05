/**
 * Created by Fei on 2/15/2018.
 */
public class SubMiniArray {
    public int minSubArray(int[] nums) {
        if (nums == null)
            return 0;

        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.min(nums[i], dp[i - 1] + nums[i]);
            min = Math.min(min,dp[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        SubMiniArray subMiniArray = new SubMiniArray();
        int[] ds = {-5,10,-4};
        subMiniArray.minSubArray(ds);
    }

}
