package binarySearch;

import org.junit.jupiter.api.Test;

import java.util.TreeSet;

public class Heaters {

    public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> set = new TreeSet();
        for (int h : heaters) {
            set.add(h);
        }
        int res = Integer.MIN_VALUE;
        for (int house : houses) {
            int left = set.floor(house) == null ? Integer.MAX_VALUE : set.floor(house);
            int right = set.ceiling(house) == null ? Integer.MAX_VALUE : set.ceiling(house);
            res = Math.max(res, Math.min(Math.abs(left - house), Math.abs(right - house)));
        }
        return res;
    }

    @Test
    public void test() {
        int[] houses = {1, 2, 3};
        int[] heaters = {2};
        System.out.println(findRadius(houses, heaters));
    }
}
