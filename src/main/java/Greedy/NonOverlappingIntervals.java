package Greedy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Input: [ [1,2], [1,2], [1,2] ]
 * <p>
 * Output: 2
 * <p>
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 */

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        int end = Integer.MIN_VALUE, count = 0;
        for (int[] cur : intervals) {
            if (cur[0] >= end) {
                count++;
                end = cur[1];
            }
        }
        return intervals.length - count;
    }

    @Test
    public void test() {
        int a = 6;
        System.out.println(a&-a);

    }

}
