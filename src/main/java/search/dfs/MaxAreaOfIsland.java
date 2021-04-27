package search.dfs;

import org.junit.jupiter.api.Test;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxAreaOfIsland {
    int M;
    int N;
    int maxSize = 0;
    int[][] directions = {
            {-1, 0},
            {0, -1},
            {1, 0},
            {0, 1}
    };

    public int maxAreaOfIsland(int[][] grid) {
        M = grid.length;
        N = grid[0].length;
        boolean[][] visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                maxSize = Math.max(maxSize, dfs(grid, i, j, visited));
            }
        }
        return maxSize;
    }

    private int dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= M || col >= N || visited[row][col] || grid[row][col] == 0) {
            return 0;
        }
        visited[row][col] = true;
        int count = 1;
        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            count += dfs(grid, nextRow, nextCol, visited);
        }
        return count;
    }

    @Test
    public void test() {
        int[][] grid = {
                {1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}
        };
        System.out.println(maxAreaOfIsland(grid));
    }

}
