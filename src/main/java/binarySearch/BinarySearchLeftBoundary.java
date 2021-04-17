package binarySearch;

import org.junit.jupiter.api.Test;

public class BinarySearchLeftBoundary {

    public int leftBoundary(int[] m, int K) {
        int l = 0;
        int r = m.length;
        while (l < r) { //左闭右开 结果集： [left,left)
            int mid = (l + r) / 2;
            if (m[mid] == K) {
                r = mid;
            } else if (m[mid] > K) {
                r = mid; //mid检测过 结果集更新为[l,mid)
            } else {
                l = mid + 1; // [mid+1,r)
            }
        }
        return m[l] == K ? l : -1;

    }

    @Test
    public void test() {
        int[] m = {1, 2, 3, 4, 4, 5, 5, 6, 7};
        System.out.println(leftBoundary(m, 5));
    }

}
