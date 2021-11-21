package binarySearch;

import org.junit.jupiter.api.Test;

public class FindSmallestLetterGreaterThanTarget {

    public int solution(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (l < arr.length) {
            return arr[l];
        }
        return -1;
    }

    @Test
    public void test() {
        int[] nums = {1,1,2,2,2,4,5};
        System.out.println(solution(nums, 5));
    }

}
