package search.dfs.backTracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    List<List<Integer>> result;
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        visited = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        dfs(nums, path);
        return result;
    }

    private void dfs(int[] nums, List<Integer> path) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == true) {
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            dfs(nums, path);
            path.remove(path.size() - 1);
            visited[i] = false;
        }

    }

    @Test
    public void test() {
        int[] m = {3,2,4,1};
        List list = permute(m);
        list.size();
    }

}
