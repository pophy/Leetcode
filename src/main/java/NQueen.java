import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fei on 2/1/2018.
 */
public class NQueen {


    public int totalNQueens(int n) {
        int[] record = new int[n];
        return helper(0, record);
    }


    private int helper(int i, int[] usedColumns) {


//        if (i == record.length) {
//            return 1;
//        }
//        int res = 0;
//        for (int j = 0; j < record.length; j++) {
//            if (isValid(record, i, j)) {
//                record[i] = j;
//                res += process1(i + 1, record);
//            }
//        }


        if (i == usedColumns.length) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < usedColumns.length; j++) {
            if (isValid(usedColumns,i, j)) {
                usedColumns[i] = j; //第rowIndex行的皇后 放在了第colIndex列
                res += helper(i + 1, usedColumns);
            }
        }
        return res;
    }


    private boolean isValid(int row, int column, int[] usedColumns) {
        for (int k = 0; k < row; k++) { //第K行
            if (k == usedColumns[row] || Math.abs(usedColumns[k] - row) == Math.abs(column - k)) {
                return false;
            }
        }
        return true;
    }



    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - i) == Math.abs(k-j)) {
                return false;
            }
        }
        return true;
    }

    public static int num1(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process1(0, record);
    }

    public static int process1(int i, int[] record) {
        if (i == record.length) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < record.length; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record);
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(num1(4));
    }


    @Test
    public void test1() {
        System.out.println(totalNQueens(4));
    }
}
