import org.testng.annotations.Test;

import java.util.*;

public class MaxNumberInSlidingWindow {

    public List<Integer> maxNumber(int[] m, int windowSize) {
        List<Integer> res = new ArrayList<>();
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < m.length; i++) {
            while (!deque.isEmpty() && m[deque.peekLast()] <= m[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (deque.peekFirst() == i - windowSize) {
                deque.pollFirst();
            }
            if (i >= windowSize - 1) {
                res.add(m[deque.pollFirst()]);
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] m = {1,3,4,3,2,1};
        maxNumber(m,3).stream().forEach(n ->{
            System.out.print(n+" ");
        });
    }


}
