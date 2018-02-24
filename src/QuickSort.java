/**
 * Created by Fei on 1/22/2018.
 */
public class QuickSort {

    public void sort2(int[] nums, int startIdx, int endIdx) {

        int idx = partition(nums, startIdx, endIdx);
        if (idx -1 > startIdx) {
            sort2(nums,startIdx,idx - 1);
        }
        if (idx + 1 < endIdx) {
            sort2(nums,idx + 1, endIdx);
        }
    }



    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        while (l <= r) {
            if (nums[l] > pivot && nums[r] < pivot) {
                swap(nums,l++, r--);
            }
            if (nums[l] <= pivot) {
                l++;
            }
            if (nums[r] >= pivot) {
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
        QuickSort sort = new QuickSort();
        int[] dataSource = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort.sort2(dataSource,0,dataSource.length-1);
        for (int i=0;i<dataSource.length;i++) {
            System.out.println(dataSource[i]);
        }
    }

}
