import java.util.Arrays;

/**
 * Created by fei on 2/2/18.
 */
public class MyQuickSort {

    public static void main(String args[]) {
        int[] input = {29,8,7,6,5,4,3,2,1};
        System.out.println("Before sorting : " + Arrays.toString(input));
        quickSort(input);
        System.out.println("After sorting : " + Arrays.toString(input));
        int[] withDuplicates = {11, 14, 16, 12, 11, 15};
        System.out.println("Before sorting : " + Arrays.toString(withDuplicates));
        quickSort(withDuplicates);
        System.out.println("After sorting : " + Arrays.toString(withDuplicates));
    }

    public static void quickSort(int[] array) {
        recursiveQuickSort(array, 0, array.length - 1);
    }

    public static void recursiveQuickSort(int[] array, int startIdx, int endIdx) {
        int idx = partition(array, startIdx, endIdx);
        if (startIdx < idx - 1) {
            recursiveQuickSort(array, startIdx, idx - 1);
        }
        if (endIdx > idx) {
            recursiveQuickSort(array, idx + 1, endIdx);
        }
    }

    public static int partition(int[] array, int left, int right) {
        int pivot = array[left];
        int l = left + 1;
        int r = right;
        while (l <= r) {
            if (array[l] > pivot && array[r] < pivot) {
                swap(array,l++,r--);
            }
            if (array[l] <= pivot) {
                l++;
            }
            if (array[r] >= pivot) {
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


}
