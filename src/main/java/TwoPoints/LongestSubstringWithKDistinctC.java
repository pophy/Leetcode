package TwoPoints;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithKDistinctC {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int max = 0, left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> countMap = new HashMap<>();
        while (right < s.length()) {
            while (right < s.length() && set.size() <= k) {
                set.add(s.charAt(right));
                countMap.put(s.charAt(right), countMap.getOrDefault(s.charAt(right), 0) + 1);
                if (set.size() <= k) {
                    max = Math.max(max, right - left + 1);
                }
                right++;
            }
            while (set.size() > k) {
                if (countMap.get(s.charAt(left)) == left) {
                    set.remove(s.charAt(left));
                }
                left++;
            }
        }
        return max;
    }

    public int lengthOfLongestSubstringKDistinct2(String s, int k) {
        if (s == null || s.isEmpty() || k < 1) {
            return 0;
        }

        int[] count = new int[256];
        int distinct = 0;
        int start = 0;
        int maxLen = 0;

        for (int end = 0; end < s.length(); ++end) {
            char c = s.charAt(end);
            if (count[c]++ == 0) {
                ++distinct;
            }

            if (distinct > k) {
                while (--count[s.charAt(start++)] > 0) {
                }
                --distinct;
            }

            maxLen = Math.max(end - start + 1, maxLen);
        }

        return maxLen;
    }

    public int longestOnes(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0, left = 0, right = 0, availableFlip = k;
        while (right < nums.length) {
            while (right < nums.length && (nums[right] == 1 || availableFlip > 0)) {
                if (nums[right] == 0) {
                    availableFlip--;
                }
                right++;
            }
            max = Math.max(max, right - left);
            while (left < nums.length && nums[left] != 0) {
                left++;
            }
            left++;
            availableFlip++;
        }
        return max;
    }


    @Test
    public void test() {
        int[] nums = {0, 0, 0};
        System.out.println(longestOnes(nums, 2));
    }

}
