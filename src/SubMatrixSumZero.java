import java.util.HashMap;

/**
 * Created by Fei on 2/14/2018.
 */
public class SubMatrixSumZero {

    public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        int[][] res = new int[2][2];
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sum = new int[m + 1][n + 1];

        for(int i = 0; i < m; i++){
            sum[i][0] = 0;
        }

        for(int j = 0; j < n; j++){
            sum[0][j] = 0;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                sum[i][j] = matrix[i - 1][j - 1] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }

        for(int l = 0; l < m; l++){
            for(int h = l + 1; h <= m; h++){
                HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
                for(int k = 0; k <= n; k++){
                    int diff = sum[h][k] - sum[l][k];
                    if(map.containsKey(diff)){
                        ////在matrix中和sum对应的点的index都要－1，在matrix中，左上角的点应该是循环中的点的右下方的点：l+1-1,map.get(diff)+1-1（即不包含循环中的左上角的点），而右下角的点是包含循环中右下角的点：h-1,k-1
                        res[0][0] = l;
                        res[0][1] = map.get(diff);
                        res[1][0] = h - 1;
                        res[1][1] = k - 1;
                        return res;
                    }else{
                        map.put(diff, k);
                    }
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        SubMatrixSumZero subMatrixSumZero = new SubMatrixSumZero();
        int[][] ds = {{1 ,5 ,7}, {3 ,7 ,-8}, {4 ,-8 ,9}};
        subMatrixSumZero.submatrixSum(ds);
    }
}
