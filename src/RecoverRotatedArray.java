import java.util.Arrays;
import java.util.List;

/**
 * Created by Fei on 1/3/2018.
 */
public class RecoverRotatedArray {

    public void recoverRotatedSortedArray(List<Integer> nums) {

        for (int i=0;i<nums.size()-1;i++) {
            if (nums.get(i) > nums.get(i+1)) {
                int pivot = i;
                int low = 0;
                int high = nums.size() -1;
                swap(nums,low,pivot);
                swap(nums,pivot + 1,high);
                //3. reverse whole list again
                swap(nums,low,high);
            }
        }
    }

    private void swap (List<Integer> nums, int low, int high) {
        while (low < high) {
            int tmp = nums.get(low);
            nums.set(low,nums.get(high));
            nums.set(high,tmp);
            low ++;
            high --;
        }
    }

    public static void main(String[] args) {
        RecoverRotatedArray recoverRotatedArray = new RecoverRotatedArray();
        Integer[] data = {1, 2, 3, 4, 5, 6};
        List<Integer> dataSource = Arrays.asList(data);
        recoverRotatedArray.recoverRotatedSortedArray(dataSource);
        System.out.print(dataSource.toArray());
    }
}
