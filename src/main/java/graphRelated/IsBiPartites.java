package graphRelated;

import org.junit.jupiter.api.Test;

public class IsBiPartites {


    int[] visited;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        visited = new int[n];
        for (int node = 0; node < n; node++) {
            if (visited[node] == 0 && !dfs(graph, node, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int node, int color) {
        if (visited[node] != 0) {
            return visited[node] == color;
        }
        visited[node] = color;
        for (int next : graph[node]) {
            if (!dfs(graph, next, -color)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[][] graph = {
                {1, 3}, {0, 2}, {1, 3}, {0, 2}
        };
        System.out.println(isBipartite(graph));
    }
}
