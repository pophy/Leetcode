package binarySearch;

import org.junit.jupiter.api.Test;

public class FindSmallestLetterGreaterThanTarget {

    public char solution(char[] arr, char target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l > arr.length ? arr[0] : arr[l];
    }

    @Test
    public void test() {
        char[] arr = {'a','b','c','e','f'};
        System.out.println(solution(arr,'d'));
    }

}
