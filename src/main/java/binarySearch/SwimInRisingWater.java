package binarySearch;

import org.junit.jupiter.api.Test;

import java.util.*;

public class SwimInRisingWater {

    int count;
    int M, N;
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] visited;

    public int swimInWater(int[][] grid) {
        count = 0;
        M = grid.length;
        N = grid[0].length;
        visited = new int[M][N];
        return bfs(grid);
    }

    private int bfs(int[][] grid) {
        PriorityQueue<Position> pq = new PriorityQueue<>(Comparator.comparingInt(a -> grid[a.x][a.y]));
        pq.add(new Position(0, 0));
        visited[0][0] = -1;
        int res = 0;
        while (!pq.isEmpty()) {
            Position currentPos = pq.poll();
            res = Math.max(res, grid[currentPos.x][currentPos.y]);
            if (currentPos.x == M - 1 && currentPos.y == N - 1) {
                return res;
            }
            for (int[] d : directions) {
                int nx = currentPos.x + d[0];
                int ny = currentPos.y + d[1];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N && visited[nx][ny] != -1) {
                    visited[nx][ny] = -1;
                    pq.add(new Position(nx, ny));
                }
            }
        }
        return -1;
    }

    private static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

    }

    @Test
    public void test() {
        int[][] board = {
                {0, 2},
                {1, 3}
        };
        System.out.println(swimInWater(board));
    }
}
