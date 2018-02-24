import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fei on 1/3/2018.
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> counter = new HashMap();
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (counter.containsKey(target - numbers[i])) {
                result[0] = counter.get(target - numbers[i]);
                result[1] = i;
                break;
            }
            counter.put(numbers[i],i);
        }
        return result;

    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] dataSource = {2,7,11,15};
        System.out.println(twoSum.twoSum(dataSource,9));
    }
}
