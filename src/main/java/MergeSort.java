import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Created by Fei on 1/22/2018.
 */
public class MergeSort {

   public void mergeSort(int[] nums, int start, int end) {
       if (start >= end) {
           return;
       }
       int mid = start + (end-start)/2;
       mergeSort(nums,start,mid);
       mergeSort(nums,mid+1,end);
       merge(nums,start,mid,end);
   }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] helper = new int[nums.length];

        int left = start;
        int right = mid + 1;
        int index = start;

        while (left <= mid && right <= end) {
            if (nums[left] < nums[right]) {
                helper[index] = nums[left];
                left++;
            } else {
                helper[index] = nums[right];
                right++;
            }
            index++;
        }
        while (left <= mid) {
            helper[index] = nums[left];
            left++;
            index++;
        }
        while (right <= end) {
            helper[index] = nums[right];
            right++;
            index++;
        }
        //copy back from helper to original array
        for (int m=start;m<=end;m++) {
            nums[m] = helper[m];
        }

    }

    @Test
    public void testSort() {
       int[] nums = {2, 2, 2, 6, 6, 6, 6, 8, 6,1,3,5};
       mergeSort(nums,0,nums.length - 1);
        System.out.println("++++++++++++++++++++++++++++++");
        Arrays.stream(nums).forEach(a -> {
            System.out.print(a + " ");
        });
    }

}
