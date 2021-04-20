package Greedy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BurstBalloons {

    public int solution(int[][] m) {
        Arrays.sort(m, (b1, b2) -> {
            return b1[0] - b2[0];
        });
        int start = m[0][0];
        int end = m[0][1];
        int count = 1;
        for (int i = 1; i < m.length; i++) {
            if (m[i][0] > end) {
                start = m[i][0];
                end = m[i][1];
                count++;
            } else {
                start = Math.max(start, m[i][0]);
                end = Math.min(end, m[i][1]);
            }
        }
        return count;
    }

    public int solution1(int[][] m) {
        Arrays.sort(m, (b1, b2) -> {
            return b1[1] - b2[1];
        });
        int end = m[0][1];
        int count = 1;
        for (int i = 1; i < m.length; i++) {
            if (m[i][0] <= end) {
                continue;
            }
            end = m[i][1];
            count++;
        }
        return count;
    }


    @Test
    public void test() {
        int[][] m = {
                {10, 16}, {2, 8}, {1, 6}, {7, 12}
        };
        System.out.println(solution(m));
        System.out.println(solution1(m));
    }
}
