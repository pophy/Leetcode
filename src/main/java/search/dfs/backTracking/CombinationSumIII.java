package search.dfs.backTracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {

    List<List<Integer>> res;

    //pick number from 1 - 9
    public List<List<Integer>> combinationSum3(int k, int sum) {
        res = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        dfs(k, sum, path, 1);

        return res;
    }

    private void dfs(int k, int target, List<Integer> path, int start) {
        if (path.size() == k) {
            if (target == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            path.add(i);
            dfs(k, target - i, path, i + 1);
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test() {
        combinationSum3(1,10).stream().forEach(l->{
            System.out.println(l);
        });
    }
}
