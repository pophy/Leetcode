import java.util.List;

public class PartitionArray {


    public int helper(int[] nums, int start, int end, int pivot) {
        int low = start;
        int high = end;
        while (low <= high) {
            while(low <= high && nums[low] < pivot) {
                low++;
            }
            while(low <= high && nums[high] >= pivot) {
                high--;
            }
            if (low <= high) {
                swap(nums, low, high);
                low++;
                high--;
            }
        }

        return low;
    }

    public void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return helper(nums, 0, nums.length - 1, k);
    }

    public static void main(String[] args) {

        int[] nums = {9,9,9,8,9,8,7,9,8,8,8,9,8,9,8,8,6,9};

        PartitionArray partitionArray = new PartitionArray();
        System.out.println(partitionArray.partitionArray(nums,9));
    }

}
