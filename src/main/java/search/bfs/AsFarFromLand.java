package search.bfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLand {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int maxDistance(int[][] grid) {
        Queue<Point> queue = new LinkedList();
        int m = grid.length, n = grid[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new Point(i, j));
                    visited[i][j] = 1;
                }
            }
        }
        int res = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point curP = queue.poll();
                for (int[] d : directions) {
                    int nX = curP.x + d[0];
                    int nY = curP.y + d[1];
                    if (nX >= 0 && nX < m && nY >= 0 && nY < n && grid[nX][nY] == 0 && visited[nX][nY] == 0) {
                        System.out.println("x: " + nX + " y: " + nY + " step: " + res);
                        queue.add(new Point(nX, nY));
                        visited[nX][nY] = 1;
                    }
                }
            }
            res++;
        }
        return res == 0 ? -1 : res;
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    @Test
    public void test() {
        int[][] grid = {
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        System.out.println(maxDistance(grid));
    }
}
