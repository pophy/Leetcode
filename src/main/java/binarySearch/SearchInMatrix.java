package binarySearch;

import org.junit.jupiter.api.Test;

public class SearchInMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target);
        if (row == -1) {
            return false;
        }
        int low = 0, high = matrix[0].length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (matrix[row][mid] == target) {
                return true;
            }
            if (matrix[row][mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return false;
    }

    private int findRow(int[][] matrix, int target) {
        int low = 0, high = matrix.length, col = matrix[0].length - 1;
        if (matrix[0][0] > target || matrix[high - 1][col] < target) {
            return -1;
        }
        while (low < high) {
            int mid = (low + high) / 2;
            if (matrix[mid][0] <= target && matrix[mid][col] >= target ) {
                return mid;
            }
            if (matrix[mid][0] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    @Test
    public void test() {
        int[][] matrix = {
                {1,3,5,7},
                {10,13,15,17},
                {21,23,25,27},
                {31,33,35,37}
        };
        System.out.println(searchMatrix(matrix, 4));
    }


}
