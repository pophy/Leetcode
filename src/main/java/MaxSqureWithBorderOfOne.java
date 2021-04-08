import org.testng.annotations.Test;

public class MaxSqureWithBorderOfOne {

    public int maxSize(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int max = -1;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                for (int k = 1; x + k <= m && y + k <= n; k++) {
                    if (check(board, x, y, k)) {
                        max = Math.max(max, k);
                    }
                }
            }
        }
        return max;
    }

    private boolean check(int[][] board, int x, int y, int k) {
        if (board[x][y] == 0) {
            return false;
        }
        for (int i = 0; i < k - 1; i++) {
            if (board[x][y + i] != 1) {
                return false;
            }
            if (board[x + i][y] != 1) {
                return false;
            }
            if (board[x + k - 1][y + i] != 1) {
                return false;
            }
            if (board[x + i][y + k - 1] != 1) {
                return false;
            }
        }
        return true;
    }

    public static int[][] generateRandom01Matrix(int rowSize, int colSize) {
        int[][] res = new int[rowSize][colSize];
        for (int i = 0; i != rowSize; i++) {
            for (int j = 0; j != colSize; j++) {
                res[i][j] = (int) (Math.random() * 2);
            }
        }
        return res;
    }

    @Test
    public void test() {
        // int[][] board = generateRandom01Matrix(5, 6);
        int[][] board = {{1, 1}, {1, 1}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("\t\n");
        }
        System.out.println(maxSize(board));
    }

}
