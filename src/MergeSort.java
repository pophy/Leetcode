import com.sun.scenario.effect.Merge;

/**
 * Created by Fei on 1/22/2018.
 */
public class MergeSort {

    private int[] temp = null;

    private void sort(int[] nums,int start, int end) {
        if (start >= end) {
            return;
        }

        //divide
        int mid = start + (end - start)/2;
        sort(nums,start,mid);
        sort(nums,mid+1,end);

        //conquer
        merge(nums,start,end,mid);

    }

    private void merge(int[] nums, int start, int end, int mid) {
        for (int i=start;i<=end;i++) {
            temp[i] = nums[i];
        }
        int left = start;
        int right = mid + 1;
        int index = start;

        while (left <= mid && right <= end) {
            if (temp[left] < temp[right]) {
                nums[index] = temp[left];
                left++;
            } else {
                nums[index] = temp[right];
                right++;
            }
            index++;
        }
        while (left <= mid) {
            nums[index] = temp[left];
            left++;
            index++;
        }
        while (right <= end) {
            nums[index] = temp[right];
            right++;
            index++;
        }

    }

    public static void main(String[] args) {
        int[] dataSource = {6,5};
        MergeSort mergeSort = new MergeSort();
        mergeSort.temp = new int[dataSource.length];
        mergeSort.sort(dataSource,0,dataSource.length-1);
        for (int i=0;i<dataSource.length;i++) {
            System.out.println(dataSource[i]);
        }
    }

}
