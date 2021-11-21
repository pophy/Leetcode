package search.dfs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PartitionArrayEqualSum {

    //  boolean[] visited;

    public boolean partition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        sum = sum / 2;
        //    visited = new boolean[nums.length];
        return dfs(nums, 0, 0, sum);
    }

    private boolean dfs(int[] nums, int sum, int index, int target) {
        if (sum > target || index >= nums.length) {
            return false;
        }
        if (sum == target) {
            return true;
        }
        for (int i = index; i < nums.length; i++) {
            if (dfs(nums, sum + nums[i], i + 1, target)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[] nums = {1,2,4};
        System.out.println(partition(nums));
    }


}
