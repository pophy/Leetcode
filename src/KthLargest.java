public class KthLargest {

    public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0 || k < 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (true) {
            int pos = partition(nums,start,end);
            if (pos + 1 == k) {
                return nums[pos];
            } else if (pos + 1 > k) {
                end = pos - 1;
            } else {
                start = pos + 1;
            }
        }
    }

    public static int partition(int[] array, int left, int right) {
        int pivot = array[left];
        int l = left + 1;
        int r = right;
        while (l <= r) {
            if (array[l] < pivot && array[r] > pivot) {
                swap(array,l,r);
                l++;
                r--;
            }
            if (array[l] >= pivot) {
                l++;
            }
            if (array[r] <= pivot) {
                r--;
            }
        }
        swap(array,left,r);
        return r;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest();
        int[] ds = {1,2,3,4,5,6,8,9,10,7};
        System.out.println(kthLargest.kthLargestElement(10,ds));
    }
}
