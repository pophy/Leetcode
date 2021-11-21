package dp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        for (int[] e : envelopes) {
            if (list.isEmpty() || list.get(list.size() - 1)[1] < e[1]) {
                list.add(e);
            } else {
                int pos = findUpperBound(list, e);
                list.set(pos, e);
            }
        }
        return list.size();
    }

    private int findUpperBound(List<int[]> list, int[] e) {
        int lower = 0, upper = list.size() - 1;
        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;
            int[] cur = list.get(mid);
            if (cur[1] >= e[1]) {
                upper = mid;
            } else {
                lower = mid + 1;
            }
        }
        return lower;
    }

    @Test
    public void test() {
        int[][] envelops = {
                {1, 3},
                {3, 5},
                {6, 7},
                {6, 8},
                {8, 4},
                {9, 5},
        };
        System.out.println(maxEnvelopes(envelops));
    }

}
