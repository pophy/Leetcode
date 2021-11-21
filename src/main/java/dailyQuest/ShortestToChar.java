package dailyQuest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestToChar {

    public int[] shortestToChar(String s, char c) {
        int[] res = new int[s.length()];
        Queue<Integer> indexQueue = new LinkedList();
        for (int i=0; i<s.toCharArray().length;i++) {
            if (s.charAt(i) == c) {
                indexQueue.add(i);
            }
        }
        int pre = -1;
        for (int i=0; i<s.toCharArray().length;i++) {
            int next = indexQueue.peek();
            res[i] = pre < 0 ? Math.abs(next-i) : Math.min(Math.abs(i-pre),Math.abs(next-i));
            if (i == indexQueue.peek() && indexQueue.size() > 1) {
                pre = indexQueue.peek();
                indexQueue.poll();
            }
        }
        return res;
    }

    public int[] shortestToChar2(String s, char c) {
        int[] res = new int[s.length()];
        int disL = s.length();
        int disR = s.length();
        for (int i=0; i<s.toCharArray().length;i++) {
            if (s.charAt(i) == c) {
                disL = 0;
            }
            res[i] = disL;
            disL++;
        }

        for (int i=s.toCharArray().length - 1; i>=0;i--) {
            if (s.charAt(i) == c) {
                disR = 0;
            }
            res[i] = Math.min(res[i],disR);
            disR++;
        }
        return res;
    }



    @Test
    public void test() {
        String s = "aaba";
        Arrays.stream(shortestToChar2(s, 'b')).forEach(n -> {
            System.out.print(n + ", ");
        });
    }

}
