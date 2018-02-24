import java.util.*;

public class UglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        List<Long> result = new ArrayList<Long>(n);
        PriorityQueue<Long> queue = new PriorityQueue();
         result.add(new Long(1));
        for (int i = 0; i < primes.length; i++) {
            queue.add(new Long(primes[i]));
        }
        while (result.size() != n) {
            long small = queue.poll();
            if (result.contains(small)) {
                continue;
            }
            result.add(small);
            for (int i = 0; i < primes.length; i++) {
                long add = small * primes[i];
                if (!queue.contains(add)) {
                    queue.offer(add);
                }
            }
        }
        return Math.toIntExact(result.get(result.size() - 1));
    }

    private void testPQ() {
        Map<String,String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String i : list) {
            System.out.println(i);
        }

        int[] ds  = {5,6,1,3,2,9,0};
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (Integer i : ds) {
            pq.offer(i);
        }
        while (!pq.isEmpty()) {
            System.out.println("---> " + pq.poll());
        }
    }


    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        int[] ds = {89,449,499,79,457,311,281,181,271,419,379,347,131};
        uglyNumber.nthSuperUglyNumber(299,ds);
//        uglyNumber.testPQ();
    }

}
