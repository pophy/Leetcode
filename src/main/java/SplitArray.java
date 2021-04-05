import org.testng.annotations.Test;

public class SplitArray {

    public int splitArray(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int i = 0, j = 0;
        while (i < nums.length && j <nums.length) {
            int x = nums[j];
            if (x <= target) {
                swap(nums,i,j);
                i++;
            }
            j++;
        }
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test(){
        int[] nums = {7,8,2,5,3,6};
        splitArray(nums,3);
    }

}
