package sweepingLine;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class SummaryRanges {

    TreeSet<int[]> set;

    public SummaryRanges() {
        set = new TreeSet<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    }

    public void addNum(int val) {
        int[] cur = new int[]{val,val};
        int[] high = set.higher(cur);
        int[] low = set.lower(cur);

        if (low != null && low[1] + 1 == val && high != null && val + 1 == high[0]) {
            low[1] = high[1];
            set.remove(high);
        } else if (low != null && low[1] + 1 >= val) {
            low[1] = Math.max(low[1],val);
        } else if (high != null && val + 1 == high[0]) {
            high[0] = val;
        } else {
            set.add(cur);
        }
    }

    public int[][] getIntervals() {
        List<int[]> res = new ArrayList<>();
        for (int[] cur : set) {
            res.add(cur);
        }
        return res.toArray(new int[set.size()][]);
    }

    @Test
    public void test() {
        SummaryRanges testSummary = new SummaryRanges();
        testSummary.addNum(6);
        testSummary.addNum(6);
        testSummary.addNum(0);
        testSummary.addNum(4);
        testSummary.addNum(8);
        testSummary.addNum(7);
        testSummary.addNum(5);
        int[][] res = getIntervals();
    }

}
