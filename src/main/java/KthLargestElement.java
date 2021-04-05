/**
 * Created by Fei on 2/15/2018.
 */
public class KthLargestElement {
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length;
        while (true) {
            int pos  = partition(nums,start,end);
            if (pos + 1 == k) {
                return nums[pos];
            } else if (pos + 1 > k) {
                end = pos - 1;
            } else {
                start = pos + 1;
            }
        }
    }


    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        while (l < r) {
            if (nums[l] > pivot && nums[r] < pivot) {
                swap(nums,l++, r--);
            }
            if (l < r && nums[l] <= pivot) {
                l++;
            }
            if (l < r && nums[r] >= pivot) {
                r--;
            }
        }
        swap(nums,left,r);
        return r;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        KthLargestElement element = new KthLargestElement();
        int[] ds = {9,3,2,4,8};
        element.kthLargestElement(3,ds);
    }

}
