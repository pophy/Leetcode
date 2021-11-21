package binarySearch;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;


public class BoatToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int count = 0;
        for (int weight : people) {
            treeMap.put(weight, treeMap.getOrDefault(weight,0) + 1);
        }
        while (!treeMap.isEmpty()) {
            count++;
            int first = treeMap.firstKey();
            int firstCnt = treeMap.get(first);
            if (firstCnt == 1) {
                treeMap.remove(first);
            } else {
                treeMap.put(first, firstCnt - 1);
            }
            if (first == limit) {
                continue;
            }
            Integer sec = treeMap.floorKey(limit - first);
            if (sec != null) {
                int secCnt = treeMap.get(sec);
                if (secCnt == 1) {
                    treeMap.remove(sec);
                } else {
                    treeMap.put(sec, secCnt - 1);
                }
            }
        }
        return count;
    }

    @Test
    public void test() {
        int[] people = {2,2,3,3,4,5};
        System.out.println(numRescueBoats(people,5));
    }

}
