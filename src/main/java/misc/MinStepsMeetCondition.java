package misc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinStepsMeetCondition {

    public int minCharacters(String a, String b) {
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        int s1 = minScenario1(A,B);
        int s2 = minScenario2(A,B);
        int s3 = minScenario3(A,B);
        return Math.min(Math.min(s1, s2), s3);
    }


    private int minScenario1(char[] a, char[] b) {
        int count = Integer.MAX_VALUE;
        for (char c = 'b'; c <= 'z'; c++) {
            int temp = 0;
            for (char ac : a) {
                if (ac >= c) {
                    temp++;
                }
            }
            for (char ac : b) {
                if (ac < c) {
                    temp++;
                }
            }
            count = Math.min(count, temp);
        }
        return count;
    }

    private int minScenario2(char[] a, char[] b) {
        int count = Integer.MAX_VALUE;
        for (char c = 'b'; c <= 'z'; c++) {
            int temp = 0;
            for (char ac : a) {
                if (ac < c) {
                    temp++;
                }
            }
            for (char ac : b) {
                if (ac >= c) {
                    temp++;
                }
            }
            count = Math.min(count, temp);
        }
        return count;
    }

    private int minScenario3(char[] a, char[] b) {
        int count = Integer.MAX_VALUE;
        for (char c = 'a'; c <= 'z'; c++) {
            int temp = 0;
            for (char ac : a) {
                if (ac != c) {
                    temp++;
                }
            }
            for (char ac : b) {
                if (ac != c) {
                    temp++;
                }
            }
            count = Math.min(count, temp);
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(minCharacters("dcced", "d"));
    }
}
