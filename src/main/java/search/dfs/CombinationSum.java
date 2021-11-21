package search.dfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> result = new ArrayList();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList();
        dfs(candidates, target, path, 0);
        return result;
    }

    private void dfs(int[] candidates, int target, List<Integer> path, int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], path, i);
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test() {
        int[] nums = {2,3,6,7};
        combinationSum(nums, 7).stream().forEach(l -> System.out.println(l));
    }

}
