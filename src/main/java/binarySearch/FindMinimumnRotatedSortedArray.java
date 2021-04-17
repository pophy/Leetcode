package binarySearch;

import org.junit.jupiter.api.Test;

public class FindMinimumnRotatedSortedArray {

    public int findMininum(int[] m) {
        int l = 0;
        int r = m.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (m[mid] < m[r]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return m[r];
    }

    @Test
    public void test() {
        int[] m = {5, 6, 7, 8, 2, 3, 4};
        System.out.println(findMininum(m));
    }

}
