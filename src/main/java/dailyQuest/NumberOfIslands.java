package dailyQuest;

import org.junit.jupiter.api.Test;

public class NumberOfIslands {

    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    counter++;
                    dfs(grid, i, j);
                }
            }
        }

        return counter;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '#' || grid[i][j] == '0') {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '#';
        }
        for (int[] direction : directions) {
            dfs(grid, i + direction[0], j + direction[1]);
        }
    }

    @Test
    public void test() {
        char[][] grid = {
                {'1','0','1','1','1'},
                {'1','0','1','0','1'},
                {'0','0','1','0','1'},
                {'0','0','1','1','1'},
        };
        System.out.println(numIslands(grid));

    }

}
