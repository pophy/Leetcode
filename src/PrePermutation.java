import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fei on 2/3/2018.
 */
public class PrePermutation {

    public List<Integer> previousPermuation(List<Integer> nums) {

        if(nums == null || nums.size() == 0){
            return nums;
        }
        //from tail, find first number smaller than previous
        int n = nums.size() - 1;
        int i = n;
        while (i > 0) {
            if (nums.get(i - 1) <= nums.get(i)) {
                i--;
            }
        }

        reverse(nums,i,n);

        if(i != 0){
            int j = i;
            while(nums.get(i - 1) <= nums.get(j)){
                j++;
            }
            swap(nums, i - 1, j);
        }

        return nums;
    }

    private void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i,nums.get(j));
        nums.set(j,temp);
    }

    private void reverse(List<Integer> nums, int start, int end) {
        while (start < end) {
            swap(nums,start++, end--);
        }
    }

    public static void main(String[] args) {
        PrePermutation prePermutation = new PrePermutation();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        prePermutation.previousPermuation(list);
    }

}
