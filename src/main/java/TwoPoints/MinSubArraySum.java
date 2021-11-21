package TwoPoints;

import org.junit.jupiter.api.Test;

public class MinSubArraySum {

    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0, right = 0, size = Integer.MAX_VALUE, sum = 0;
        boolean flag = false;
        while (right < nums.length) {
            while (right < nums.length && sum < target) {
                sum += nums[right];
                right++;
            }
            while (left < nums.length && sum >= target) {
                flag = true;
                size = Math.min(size, right - left);
                sum -= nums[left];
                left++;
            }
        }
        return flag ? size : 0;
    }



    public int minSubArrayLenI(int s, int[] nums) {
        int lo = 0, hi = 0, sum = 0, min = Integer.MAX_VALUE;
        while (hi < nums.length) {
            sum += nums[hi++];
            while (sum >= s) {
                min = Math.min(min, hi - lo);
                sum -= nums[lo++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }



    @Test
    public void test() {
        System.out.println(minSubArrayLen(7,new int[]{2,3,1,2,4,3}));;
    }

}
