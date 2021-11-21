package islandRelated;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandBFS {

    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int counter = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    counter++;
                    bfs(grid, i, j);
                }
            }
        }
        return counter;
    }

    private void bfs(char[][] grid, int row, int col) {
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{row, col});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
                continue;
            }
            grid[x][y] = '0';
            for (int[] d : directions) {
                int nx = x + d[0];
                int ny = y + d[1];
                queue.add(new int[]{nx, ny});
            }
        }
    }

    @Test
    public void test() {
        char[][] grid = {
                {'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}      
        };
        System.out.println(numIslands(grid));
    }

}
