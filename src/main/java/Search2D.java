/**
 * Created by Fei on 2/1/2018.
 */
public class Search2D {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int row_num = matrix.length;
        int col_num = matrix[0].length;

        int begin = 0, end = row_num * col_num - 1;

        while(begin <= end){
            int mid = (begin + end) / 2;
            int mid_value = matrix[mid/col_num][mid%col_num];

            if( mid_value == target){
                return true;

            }else if(mid_value < target){
                //Should move a bit further, otherwise dead loop.
                begin = mid+1;
            }else{
                end = mid-1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Search2D search2D = new Search2D();
        int[][] ds = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        search2D.searchMatrix(ds,7);
    }

}
