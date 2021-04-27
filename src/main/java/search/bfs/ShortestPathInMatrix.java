package search.bfs;


import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInMatrix {

    int M;
    int N;

    public int solution(int[][] m) {
        //validate matrix
        M = m.length;
        N = m[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int[][] directions = {
                {-1, -1},
                {-1, 0},
                {-1, 1},
                {0, 1},
                {1, 0},
                {1, 1},
                {0, -1},
                {1, -1}
        };
        queue.add(new Pair(0, 0));
        int pathLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                int cr = pair.row, cc = pair.col;
                if (m[cr][cc] == 1) {
                    continue;
                }
                if (cr == m.length - 1 && cc == m[0].length - 1) {
                    return pathLength;
                }
                for (int[] d : directions) {
                    int nextR = cr + d[0];
                    int nextC = cc + d[1];
                    if (nextC >= 0 && nextR >= 0 && nextR < M && nextC < N) {
                        queue.add(new Pair(nextR, nextC));
                    }
                }
            }

        }
        return pathLength;
    }

    private static class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    @Test
    public void test() {
        int[][] m = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(solution(m));
    }

}
