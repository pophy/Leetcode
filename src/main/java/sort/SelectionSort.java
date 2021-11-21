package sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SelectionSort {

    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums,i,minIndex);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test() {
        int[] nums = {8,6,3,1,3,8,5};
        sort(nums);
        Arrays.stream(nums).forEach( i -> {
            System.out.println(i);
        });
    }

}
