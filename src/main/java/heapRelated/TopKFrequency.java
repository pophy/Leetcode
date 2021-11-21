package heapRelated;

import org.junit.jupiter.api.Test;

import java.util.*;

public class TopKFrequency {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            priorityQueue.add(entry);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        List<Integer> resList = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            resList.add(priorityQueue.poll().getKey());
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]) );
        for (int i=0; i < points[i].length; i++) {
            pq.add(points[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] res = new int[pq.size()][2];
        int count = 0;
        while (!pq.isEmpty()) {
            int[] point = pq.poll();
            res[count][0] = point[0];
            res[count][1] = point[1];
            count++;
        }
        return res;
    }
    @Test
    public void test() {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(topKFrequent(nums,2));
    }

}
