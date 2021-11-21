package search.dfs;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;


public class ShortestCycleContainingTarget {

    public int solve(int[][] graph, int target) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(target);
        visited[target] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int next : graph[cur]) {
                    if (next == target) {
                        return step + 1;
                    } else if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    @Test
    public void test() {
        int[][] graph = {{}, {0, 1}};
        System.out.println(solve(graph, 1));
    }
}
