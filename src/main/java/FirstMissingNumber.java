/**
 * Created by Fei on 2/11/2018.
 */
public class FirstMissingNumber {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < nums.length; i++){
            while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]){
                swap(nums, nums[i]-1, i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        FirstMissingNumber firstMissingNumber = new FirstMissingNumber();
        int[] ds = {3,4,-1,1};
        firstMissingNumber.firstMissingPositive(ds);

    }

}
