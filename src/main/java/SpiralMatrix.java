import org.junit.jupiter.api.Test;

/**
 * Created by Fei on 2/13/2018.
 */
public class SpiralMatrix {

    private int counter;

    public int[][] generateMatrix(int n) {
        counter = 1;
        int[][] matrix = new int[n][n];
        int rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = n - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            if (rowStart == rowEnd && colStart == colEnd) {
                matrix[rowStart][colStart] = counter;
                break;
            }
            printBorder(matrix,rowStart++,colStart++,rowEnd--,colEnd--);
        }
        return matrix;
    }


    private void printBorder(int[][] matrix, int rowStart,int colStart,int rowEnd, int colEnd) {
        int curRow = rowStart;
        int curCol = colStart;

        //top
        while (curCol < colEnd) {
            matrix[curRow][curCol] = counter;
            curCol++;
            counter++;
        }
        //right

        while (curRow < rowEnd) {
            matrix[curRow][curCol] = counter;
            curRow++;
            counter++;
        }
        //botoom

        while (curCol > colStart) {
            matrix[curRow][curCol] = counter;
            curCol--;
            counter++;
        }
        //left

        while (curRow > rowStart) {
            matrix[curRow][curCol] = counter;
            curRow--;
            counter++;
        }
    }


    @Test
    public void newTest() {
        SpiralMatrix test = new SpiralMatrix();
        int[][] matrix = test.generateMatrix(3);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\t\n");
        }
    }

}
