/**
 * Created by Fei on 2/11/2018.
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] > nums[i + 1]) {
            i--;
        }
        if (i < 0) {
            reverse(nums,0,n - 1);
        } else {
            int largeIndex = -1;
            for (int j = n - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    largeIndex = j;
                    break;
                }
            }

            swap(nums,i,largeIndex);
            reverse(nums,i + 1,n - 1);
        }



    }

    private void swap(int[] nums, int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums,start++, end--);
        }
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] ds = {1,3,2};
        nextPermutation.nextPermutation(ds);
    }
}
