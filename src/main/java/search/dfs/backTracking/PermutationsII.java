package search.dfs.backTracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    List<List<Integer>> result;
    boolean[] visited;

    public List<List<Integer>> permute(int[] m) {
        result = new ArrayList<>();
        visited = new boolean[m.length];
        List<Integer> path = new ArrayList<>();
        Arrays.sort(m);
        dfs(m, path);
        return result;
    }

    private void dfs(int[] m, List<Integer> path) {
        if (path.size() == m.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < m.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && m[i] == m[i - 1] && visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            path.add(m[i]);
            dfs(m, path);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test() {
        int[] m = {1, 1};
        List list = permute(m);
        System.out.println(list);
    }

}
