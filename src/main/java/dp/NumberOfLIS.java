package dp;

import java.util.Arrays;

public class NumberOfLIS {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] len = new int[n];
        int[] count = new int[n];
        Arrays.fill(len, 1);
        Arrays.fill(count, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (len[j] + 1 > len[i]) {
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    } else if (len[j] + 1 == len[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }
        int maxLen = 1, maxCount = 1;
        for (int i = 0; i < len.length; i++) {
            if (len[i] > maxLen) {
                maxLen = len[i];
                maxCount = count[i];
            } else if (len[i] == maxLen) {
                maxCount += count[i];
            }
        }
        return maxCount;
    }
}
