package dp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (!list.isEmpty() && list.get(list.size() - 1) >= num) {
                //find first num in list that is large than num, replace it with num
                int pos = getLowerBound(list, num);
                list.set(pos, num);
            } else {
                list.add(num);
            }
        }
        return list.size();
    }

    private int getLowerBound(List<Integer> list, int key) {
        int lower = 0, upper = list.size() - 1;
        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;
            if (list.get(mid) >= key) {
                upper = mid;
            } else {
                lower = mid + 1;
            }
        }
        return lower;
    }


    @Test
    public void test() {
        int[] nums = {7,7,7};
        System.out.println(lengthOfLIS(nums));

    }
}
