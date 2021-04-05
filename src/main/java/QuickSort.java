import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Created by Fei on 1/22/2018.
 */
public class QuickSort {

   public void quickSort(int[] nums, int start, int end) {
        int index = partition(nums,start,end);
        if (index - 1 > start) {
            quickSort(nums,start,index-1);
        }
        if (index + 1 < end) {
            quickSort(nums,index+1,end);
        }
   }

   public int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int left = start + 1;
        int right = end;
        while (left <= right) {  //
            if (nums[left] > pivot && nums[right] < pivot) {
                swap(nums,left++,right--);
            }
            if (nums[left] <= pivot) {
                left++;
            }
            if (nums[right] >= pivot) {
                right--;
            }
        }
        swap(nums,start,right);
        return right;
   }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    private void test() {
       int[] nums = NumUtil.generateRandomNumbers(20,15);
       quickSort(nums,0,nums.length-1);
        Arrays.stream(nums).forEach(a->{
            System.out.print(a+" ");
        });
    }

}
