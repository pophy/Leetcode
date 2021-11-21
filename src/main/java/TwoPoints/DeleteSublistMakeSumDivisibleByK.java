package TwoPoints;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class DeleteSublistMakeSumDivisibleByK {

    public int minSubarray(int[] nums, int k) {
        int res = nums.length;
        int p = 0;
        long[] presum = new long[nums.length + 1];
        Map<Long, Integer> modIndexMap = new HashMap<>();
        modIndexMap.put(0l, -1);
        presum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            p = (p + nums[i]) % k;
            presum[i + 1] = presum[i] + nums[i];
        }
        if (p == 0) {
            return 0;
        }
        for (int j = 0; j < nums.length; j++) {
            long temp = presum[j + 1] % k;
            long curMod = (temp - p + k) % k;
            if (modIndexMap.containsKey(curMod)) {
                int left = modIndexMap.get(curMod);
                res = Math.min(res, j - left);
            }
            modIndexMap.put(presum[j + 1] % k, j);
        }
        return res == nums.length ? -1 : res;
    }

    @Test
    public void test() {
        int[] nums = {1,2,10};
        System.out.println(minSubarray(nums, 7));
    }


}


/**
 * totalSum % k = p
 * sum[i,j] % k = p
 * presum[j] % k - presum[i-1] % k = p
 * presum[i-1] % k = presum[j] % k - p
 * X X X X [i X X X X j] X X X
 */
