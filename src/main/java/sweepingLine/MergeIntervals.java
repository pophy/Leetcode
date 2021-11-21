package sweepingLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {

    public List<int[]> mergeIntervals(int[][] intevals) {
        if (intevals == null) {
            return null;
        }
        Arrays.sort(intevals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int[] cur = intevals[0];
        for (int i = 1; i < intevals.length; i++) {
            int[] next = intevals[i];
            if (next[0] > cur[1]) {
                res.add(cur);
                cur = next;
            } else {
                if (next[1] < cur[1]) {
                    continue;
                } else {
                    cur[1] = next[1];
                }
            }
        }
        return res;
    }

}
