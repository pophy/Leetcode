import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fei on 2/1/2018.
 */
public class NQueen {

    private int counter = 0;
    private int[] rows = new int[100];
    private boolean[] usedRows = new boolean[100];
    private boolean[] diag = new boolean[100];
    private boolean[] diagX = new boolean[100];

    public int totalNQueens(int n) {
        int[] usedColumns = new int[n];
        robot(0,usedColumns);
        return counter;
    }

    private void robot(int column, int[] usedColumns) {
        if (column == usedColumns.length) {
            counter++;
            return;
        }
        for (int row=0;row < usedColumns.length; row++) {
            if (isValid(row,column,usedColumns)) {
                usedColumns[column] = row;
                robot(column + 1, usedColumns);
            }
        }
    }

    private boolean isValid(int row, int column,int[] usedColumns) {
        for (int i = 0; i < row; i++) {
            if (usedColumns[i] == column) {
                return false;
            }
            if ((row - i) == Math.abs(column-usedColumns[i])) {
                return false;
            }
        }
        return true;
    }

}
