package Greedy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AssignCookies {

    public int solution(int[] kids, int[] cookies) {
        Arrays.sort(kids);
        Arrays.sort(cookies);
        int count = 0;
        int i = 0; //kids pointer
        int j = 0; // cookies pointer
        while (i < kids.length && j < cookies.length) {
            while (cookies[j] < kids[i]) {
                j++;
            }
            count++;
            i++;
        }
        return count;
    }

    @Test
    public void test() {
        int[] kids = {1,2,3};
        int[] cookies = {1,1,2,4};
        System.out.println(solution(kids,cookies));
    }
}
