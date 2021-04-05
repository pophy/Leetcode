/**
 * Created by Fei on 2/13/2018.
 */
public class SpiralMatrix {
    public int[][] generateMatrix(int n) {
        if (n < 0) return new int[0][0];
        int rowStart = 0; int rowEnd = n - 1;
        int colStart = 0; int colEnd = n - 1;
        int count = 1;
        int[][] result = new int[n][n];

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                result[rowStart][i] = count++;
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                result[i][colEnd] = count++;
            }
            colEnd--;
            if (rowStart > rowEnd || colStart > colEnd) {
                break;
            }
            for (int i = colEnd; i >= colStart; i--) {
                result[rowEnd][i] = count++;
            }
            rowEnd--;
            for (int i = rowEnd; i >= rowStart; i--) {
                result[i][colStart] = count++;

            }
            colStart++;
        }
        if(n%2==1) result[n/2][n/2] = n*n;
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        spiralMatrix.generateMatrix(5);
    }
}
