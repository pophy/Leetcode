package dailyQuest;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TwoSumRelated {

    public int[] generatePrefixSum(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        return sum;
    }

    public int subarraySum(int[] nums, int k) {
        //pre sum
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        //k = presum[j] - presum[i]
        //presum[i] = presum[j] - k
        //2sum
        //use map to record frequency
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        int res = 0;
        for (int i = 0; i < sum.length; i++) {
            int diff = sum[i] - k;
            if (map.containsKey(diff)) {
                res = res + map.getOrDefault(diff, 0);
            }
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }
        return res;
    }

    public int subArrayDivByK(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        int res = 0;
        int prefix = 0;
        for (int i = 0; i < sum.length; i++) {
            prefix = Math.abs(sum[i] % k);
            res = res + map.getOrDefault(prefix, 0);
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return res;
    }


    @Test
    public void test() {
        int[] num = {1, 2, 3, 3};
        System.out.println(subarraySum(num, 3));
    }

    @Test
    public void test1() {
        int[] num = {4,5,0,-2,-3,1};
        System.out.println(subArrayDivByK(num, 5));
    }

}
