package search.dfs;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberOfIslands {
    int M;
    int N;
    int[][] directions = {
            {-1, 0},
            {0, -1},
            {1, 0},
            {0, 1}
    };

    public int numIslands(char[][] grid) {
        M = grid.length;
        N = grid[0].length;
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != '0') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= M || c < 0 || c >= N || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        for (int[] direction : directions) {
            int nextR = r + direction[0];
            int nextC = c + direction[1];
            dfs(grid, nextR, nextC);
        }
    }
}
