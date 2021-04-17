package sort;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 */
public class TopKFrequentElement {

    public List<Integer> solution(int[] m, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < m.length; i++) {
            if (!countMap.containsKey(m[i])) {
                countMap.put(m[i], 0);
            }
            countMap.put(m[i], countMap.get(m[i]) + 1);
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>((n1,n2) -> {
            return n1.count-n2.count;
        });
        for(Integer num : countMap.keySet()) {
            Pair pair = new Pair(num,countMap.get(num));
            queue.add(pair);
            if (queue.size() > 2) {
                queue.poll();
            }

        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.poll().Num);
        }
        return res;
    }

    private static class Pair {
        int Num;
        int count;

        public Pair(int num, int count) {
            Num = num;
            this.count = count;
        }
    }

    @Test
    public void test() {
        int[] m = {1,1,1,2,2,3};
        solution(m,2).forEach(n->{
            System.out.println(n);
        });
    }

}
