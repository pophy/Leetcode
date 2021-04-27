package search.unionFind;

import org.junit.jupiter.api.Test;

import java.util.*;

public class SurroundedRegions {
    int M;
    int N;
    int[][] directions = {
            {-1, 0},
            {0, -1},
            {1, 0},
            {0, 1}
    };

    public void solve(char[][] board) {
        M = board.length;
        N = board[0].length;
        //init UF
        UnionFind uf = new UnionFind();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                Pair pair = new Pair(i, j);
                uf.parentMap.put(pair, pair);
                uf.idMap.put(i * M + j, pair);
            }
        }
        Pair edgeO = new Pair(M, N);
        uf.parentMap.put(edgeO, edgeO);
        uf.idMap.put(M * N, edgeO);

        //connect
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    //union 'O's on edges
                    Pair p1 = uf.idMap.get(i * M + j);
                    if (i == 0 || j == 0 || i == M - 1 || j == N - 1) {
                        uf.connect(p1, edgeO);
                    } else {
                        for (int[] d : directions) {
                            int nextR = i + d[0];
                            int nextC = j + d[1];
                            if (nextR >=0 && nextR < M && nextC >=0 && nextC < N) {
                                if (board[i + d[0]][j + d[1]] == 'O') {
                                    Pair p2 = uf.idMap.get(nextR * M + nextC);
                                    uf.connect(p1, p2);
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'O') {
                    Pair p = uf.idMap.get(i * M + j);
                    if (uf.findParent(p) != edgeO) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }


    private static class UnionFind {

        Map<Pair, Pair> parentMap = new HashMap<>();
        Map<Integer, Pair> idMap = new HashMap<>();

        public Pair findParent(Pair pair) {
            Stack<Pair> path = new Stack<>();
            Pair parent = parentMap.get(pair);
            while (parentMap.get(parent) != parent) {
                path.push(parent);
                parent = parentMap.get(parent);
            }
            while (!path.isEmpty()) {
                Pair p = path.pop();
                parentMap.put(p, parent);
            }
            return parent;
        }

        public void connect(Pair p1, Pair p2) {
            if (findParent(p1) != findParent(p2)) {
                Pair parent1 = findParent(p1);
                Pair parent2 = findParent(p2);
                parentMap.put(parent1, parent2);
            }
        }


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
        char[][] board = {
                {'O','O','O'},
                {'O','O','O'},
                {'O','O','O'}
        };
        solve(board);
    }

}
