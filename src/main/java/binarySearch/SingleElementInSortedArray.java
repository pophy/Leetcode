package binarySearch;

import org.junit.jupiter.api.Test;

public class SingleElementInSortedArray {

    public int findSingleELement(int[] m) {
        int l = 0;
        int r = m.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid % 2 == 1) {  //odd index
                mid--;
            }
            //122|3344
            if (m[mid] != m[mid + 1]) {
                r = mid;
            } else {
                //112|2344
                l = mid + 2;
            }
        }
        return m[l];
    }

    @Test
    public void test() {
        int[] m = {1,1,2,3,3,4,4,5,5};
        System.out.println(findSingleELement(m));
    }

}
