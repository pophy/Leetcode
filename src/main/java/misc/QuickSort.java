package misc;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class QuickSort {

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private int[] sort(int[] nums, int start, int end) {
        int k = partition(nums, start, end);
        if (k - 1 > start) {
            sort(nums, start, k - 1);
        }
        if (k + 1 < end) {
            sort(nums, k + 1, end);
        }
        return nums;
    }

    private int partition(int[] nums, int start, int end) {
        int random = getRandom(start, end);
        System.out.println(random);
        swap(nums, random, start);
        int pivot = nums[start];
        int l = start + 1, r = end;
        while (l <= r) {
            if (nums[l] > pivot && nums[r] < pivot) {
                swap(nums, l++, r--);
            } else if (nums[l] <= pivot) {
                l++;
            } else if (nums[r] >= pivot) {
                r--;
            }
        }
        swap(nums, r, start);
        return r;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int getRandom(int min, int max) {
        if (min == max) {
            return min;
        }
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    @Test
    public void test() {
        int[] nums = {0};
        System.out.println(sortArray(nums));
    }
}
