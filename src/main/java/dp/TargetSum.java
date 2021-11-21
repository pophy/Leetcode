package dp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap();
        dp.put(0, 1);
        for (int num : nums) {
            Map<Integer, Integer> dp2 = new HashMap();
            for (int tempSum : dp.keySet()) {
                int key1 = tempSum + num;
                dp2.put(key1, dp2.getOrDefault(key1, 0) + dp.get(tempSum));
                int key2 = tempSum - num;
                dp2.put(key2, dp2.getOrDefault(key2, 0) + dp.get(tempSum));
            }
            dp = dp2;
        }
        return dp.getOrDefault(target, 0);
    }

    @Test
    public void test() {
        int[] nums = {1, 1};
        System.out.println(findTargetSumWays(nums, 0));
    }

}
