/**
 * Created by Fei on 2/4/2018.
 */
public class KthLargest {


    public int median(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        return partition(nums, 0, nums.length - 1,nums.length/2);

    }



    private int partition(int[] nums, int start, int end, int targetIndex) {
        int l = start + 1;
        int r = end;
        int pivot = nums[start];
        while (l < r) {
            if (nums[l] > pivot && nums[r] < pivot ) {
                swap(nums,l++,r--);
            }
            if (l < r && nums[l] >= pivot) {
                l++;
            }
            if (l < r && nums[r] <= pivot) {
                r--;
            }
        }
        swap(nums,start,r);

        if (r == targetIndex) {
            return nums[r];
        } else if (r > targetIndex) {
            return partition(nums, start,r - 1,targetIndex);
        } else {
            return partition(nums, r + 1,end,targetIndex);
        }
    }

    private void swap(int[] nums, int i , int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest();
        int[] ds = {9,8,7,6,5,4,3,2,1};
        System.out.println(kthLargest.median(ds));;
    }

}
