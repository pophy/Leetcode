package binarySearch;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.PriorityQueue;

public class KoKoEatBanana {

    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length > h) {
            return -1;
        }
        int maxPile = Arrays.stream(piles).max().getAsInt();
        int left = 1, right = maxPile;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (getHours(piles, mid) == h) {
                right = mid;
            } else if (getHours(piles, mid) < h) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (getHours(piles, left) <= h) {
            return left;
        }
        if (getHours(piles, right) <= h) {
            return right;
        }
        return -1;
    }

    private int getHours(int[] piles, int k) {
        int h = 0;
         for (int pile : piles) {
            h = h + pile / k;
            if (pile % k != 0) {
                h++;
            }
        }
        return h;
    }


    /**
     * [312884470]
     * 312884469
     *
     * [312884470]
     * 968709470
     */


    @Test
    public void test() {
        int[] piles = {312884470};
        System.out.println(minEatingSpeed(piles,968709470));
    }

}
