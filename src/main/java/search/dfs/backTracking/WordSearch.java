package search.dfs.backTracking;

import org.junit.jupiter.api.Test;

public class WordSearch {

    int M;
    int N;
    boolean[][] visited;
    int[][] directions = {
            {-1, 0},
            {0, -1},
            {1, 0},
            {0, 1}
    };

    public boolean exist(char[][] board, String word) {
        M = board.length;
        N = board[0].length;
        visited = new boolean[M][N];
        boolean res = false;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                res = res | search(board, word, i, j, 0);
            }
        }
        return res;
    }

    private boolean search(char[][] board, String word, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= M || col < 0 || col >= N || board[row][col] != word.charAt(index)) {
            return false;
        }
        if (index == word.length()) {
            return true;
        }
        if (visited[row][col]) {
            return false;
        }
        for (int[] d : directions) {
            int nextR = row + d[0];
            int nextC = col + d[1];
            visited[row][col] = true;
            if (search(board, word, nextR, nextC, index + 1)) return true;
            visited[row][col] = false;
        }
        return false;
    }

    @Test
    public void test() {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };
        System.out.println(exist(board, "BCESE"));


    }

}
