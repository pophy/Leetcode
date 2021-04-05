import org.testng.annotations.Test;

/**
 * Created by Fei on 2/5/2018.
 */
public class Backpack {

    public int getMaxProfit(int bagSize, int[] weights, int[] values) {
        return process(bagSize,weights,values,0);
    }

    private int process(int remainingSize, int[] weights, int[] values, int index) {
        if (index == values.length) {
            return 0;
        }
        if (remainingSize < weights[index]) {
            return 0;
        }
        int take = process(remainingSize-weights[index],weights,values,index+1) + values[index];
        int noTake = process(remainingSize,weights,values,index+1);
        return Math.max(take,noTake);
    }

    @Test
    public void test() {
        int[] weight = {2,3,5};
        int[] values = {10,2,5};
        System.out.println(getMaxProfit(5,weight,values));
    }
}
