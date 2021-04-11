import org.testng.annotations.Test;

public class FindNumberInSortedMatrix {

    public boolean findNumber(int[][] m, int t) {
        int rowSize = m.length;
        int colSize = m[0].length;
        int curRow = 0;
        int curCol = colSize - 1;

        while (curRow < rowSize && curCol >= 0) {
            if (m[curRow][curCol] > t) {
                curCol--;
            } else if (m[curRow][curCol] < t) {
                curRow++;
            } else {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test(){
        int[][] m = {
                {1,3,5,7},
                {2,4,6,8},
                {9,11,13,15},
                {17,19,20,21}
        };
        System.out.println(findNumber(m,11));
    }

}
