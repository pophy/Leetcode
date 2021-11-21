package search.dfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subset {

    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList();
        dfs(nums, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(int[] nums, List<Integer> path, int index) {
        result.add(new ArrayList(path));
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, path, i + 1);
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test() {
        int[] nums = {1,1,2};
        System.out.println(subsets(nums));
    }

}
