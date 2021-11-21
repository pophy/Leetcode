package search.dfs;

import org.junit.jupiter.api.Test;
import java.util.TreeSet;

public class ClosestSubsequenceSum {

    public int minAbsDifference(int[] nums, int goal) {
        TreeSet<Integer> first = new TreeSet<>();
        TreeSet<Integer> second = new TreeSet<>();
        generateSubsetSum(nums, 0, nums.length / 2, 0, first);
        generateSubsetSum(nums, nums.length / 2, nums.length, 0, second);
        return findAns(first, second, goal);
    }

    private int findAns(TreeSet<Integer> first, TreeSet<Integer> second, int goal) {
        int res = Integer.MAX_VALUE;
        for (int num : first) {
            int key = goal - num;
            if (second.floor(key) != null) {
                res = Math.min(res, Math.abs(num + second.floor(key) - goal));
            }
            if (second.ceiling(key) != null) {
                res = Math.min(res, Math.abs(num + second.ceiling(key) - goal));
            }
        }
        return res;
    }

    private void generateSubsetSum(int[] nums, int start, int end, int sum, TreeSet<Integer> list) {
        list.add(sum);
        for (int i = start; i < end; i++) {
            sum += nums[i];
            generateSubsetSum(nums, i + 1, end, sum, list);
            sum -= nums[i];
        }
    }

    @Test
    public void test() {
        int[] nums = {5,-7,3};
        //System.out.println(minAbsDifference(nums, 6));
        TreeSet<Integer> first = new TreeSet<>();
        generateSubsetSum(nums, 0, 2, 0, first);
        System.out.println();
    }

}
