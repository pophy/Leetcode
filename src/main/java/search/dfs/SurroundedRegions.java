package search.dfs;

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


        //dfs from borad edges, if value == 'O', dfs mark all 'O' to '#'
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                boolean isEdge = i == 0 || j == 0 || i == M - 1 || j == N - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        //loop through borad, change '#' to 'O', and 'O' to 'X'
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= M || c < 0 || c >= N || board[r][c] == '#' || board[r][c] == 'X') {
            return;
        }
        board[r][c] = '#';
        for (int[] d : directions) {
            dfs(board, r + d[0], c + d[1]);
        }
    }
}
