package hashMapRelated;

import org.junit.jupiter.api.Test;

public class ValidSoduku {
    public boolean isValidSudoku(char[][] board) {

        int[] points = {0, 3, 6};

        //check row
        for (int i = 0; i < 9; i++) {
            int[] map = new int[9];
            for (int j = 0; j < 9; j++) {
                if (haveDuplicate(map, board[i][j])) {
                    return false;
                }
            }
        }
        //check column
        for (int i = 0; i < 9; i++) {
            int[] map = new int[9];
            for (int j = 0; j < 9; j++) {
                if (haveDuplicate(map, board[j][i])) {
                    return false;
                }
            }
        }
        //check sub box
        for (int x : points) {
            for (int y : points) {
                int[] map = new int[9];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int row = x + i;
                        int column = y + j;
                        if (haveDuplicate(map, board[row][column])) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean haveDuplicate(int[] map, char c) {
        if (c == '.') {
            return false;
        }
        if (map[c - '0'] != 0) {
            return true;
        }
        map[c - '0'] = 1;
        return false;
    }





    @Test
    public void test() {
        int[] map = new int[9];
        haveDuplicate(map, '2');
    }

}
