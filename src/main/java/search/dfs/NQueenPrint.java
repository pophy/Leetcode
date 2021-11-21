package search.dfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueenPrint {

    int n;
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(0, board);
        return res;
    }

    private void dfs(int row, char[][] board) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (char[] str : board) {
                StringBuilder sb = new StringBuilder();
                for (char c : str) {
                    sb.append(c);
                }
                temp.add(sb.toString());
            }
            res.add(temp);
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, board)) {
                board[row][col] = 'Q';
                dfs(row + 1, board);
                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(int row, int col, char[][] board) {
        for (int k = 0; k < row; k++) {
            if (board[k][col] == 'Q') {
                return false;
            }
        }
        for (int k = 0; k < col; k++) {
            if (board[row][k] == 'Q') {
                return false;
            }
        }
        int k = 1;
        while (row - k >= 0 && col - k >= 0) {
            if (board[row - k][col - k] == 'Q') {
                return false;
            }
            k++;
        }
        k = 1;
        while (row - k >= 0 && col + k < n) {
            if (board[row - k][col + k] == 'Q') {
                return false;
            }
            k++;
        }
        return true;
    }

    @Test
    public void test() {
        List<List<String>> result = solveNQueens(4);
        for (List<String> temp : result) {
            for (String str : temp) {
                System.out.println(str);
            }
            System.out.println("------------");
        }
    }

}
