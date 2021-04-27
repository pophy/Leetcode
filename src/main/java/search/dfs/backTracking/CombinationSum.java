package search.dfs.backTracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(candidates, target, path, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, LinkedList<Integer> path, int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
        }
        for (int i = index; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            dfs(candidates, target - candidates[i], path, i);
            path.removeLast();
        }
    }

    @Test
    public void test() {
        int[] m = {2, 3, 6, 7};
        combinationSum(m, 7).stream().forEach(l -> {
            System.out.println(l);
        });
    }
}
