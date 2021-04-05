import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    public static int binarySearch(int[] nums, int target) {
       int l = 0;
       int r = nums.length - 1;
       while (l <= r) {
           int mid = l + (r - l)/2;
           if (nums[mid] > target) {
               r = mid - 1;
           } else if (nums[mid] < target) {
               l = mid + 1;
           } else {
               return mid;
           }
       }
       return -1;
    }

    public static int binarySearchLeft(int[] nums, int target) {
        //corner case checks
        if (nums[0] > target || nums[nums.length-1] < target) {
            return -1;
        }
        //skipped
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
               r = mid - 1;
            }

        }
        if (l >= nums.length || nums[l] != target) {
            return -1;
        }
        return l;
    }


    @Test
    public void test1() {
//        int[] nums = NumUtil.generateRandomNumbers(15,30);
//        Arrays.stream(nums).forEach(a->{
//            System.out.print(a + ",");
//        });
        int[] nums = {2, 8, 22, 14, 1, 11, 27, 17, 25};
        System.out.println(binarySearch(Arrays.stream(nums).sorted().toArray(), 33));
    }

    @Test
    public void test2() {
        int[] nums = {1,1,1,2,2,2,3,3,3};
        System.out.println(binarySearchLeft(nums,4));
    }

}


