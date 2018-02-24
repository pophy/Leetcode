import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Fei on 1/31/2018.
 */
public class Dice {
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        List<Map.Entry<Integer, Double>> result = new ArrayList<Map.Entry<Integer, Double>>();
        if(n < 1){
            return result;
        }
        //初始化n＝1的情况
        double[][] matrix = new double[n + 1][6 * n + 1];
        for(int i = 1; i <= 6; i++){
            matrix[1][i] = 1.0/6;
        }

        for(int i = 2; i <= n; i++){
            //i个筛子至少得到i点，至多得到6 * i点
            for(int j = i; j <= 6 * i; j++){
                //k表示最后一个筛子能取的点数
                for(int k = 1; k <= 6; k++){
                    if(k <= j - i + 1){
                        matrix[i][j] += matrix[i - 1][j - k];
                    }
                }
                //相对i－1个筛子多了一个筛子，因此加和的每一项都要除以6
                matrix[i][j] /= 6.0;
            }
        }

        for(int i = n; i <= 6 * n; i++){
            result.add(new SimpleEntry<Integer, Double>(i, matrix[n][i]));
        }

        return result;
    }

    public static void main(String[] args) {
        Dice dice = new Dice();
        dice.dicesSum(3);
    }

    private class SimpleEntry<T, T1> implements Map.Entry<Integer, Double> {
        public SimpleEntry(int i, double v) {

        }

        @Override
        public Integer getKey() {
            return null;
        }

        @Override
        public Double getValue() {
            return null;
        }

        @Override
        public Double setValue(Double value) {
            return null;
        }
    }
}
