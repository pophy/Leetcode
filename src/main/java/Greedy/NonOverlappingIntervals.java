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

    public int solution(int[][] sections) {
        Arrays.sort(sections, (s1, s2) -> {
            return s1[1] - s2[1];
        });
        int count = 0;
        int end = 0;
        for (int i = 0; i < sections.length; i++) {
            int[] section = sections[i];
            if (section[0] >= end) {
                end = section[1];
                count++;
            }
        }
        return sections.length - count;
    }

    @Test
    public void test() {
        int[][] sections = {
                {1, 2}, {4, 7}, {3, 4}, {3, 8}
        };
        System.out.println(solution(sections));
    }

}
