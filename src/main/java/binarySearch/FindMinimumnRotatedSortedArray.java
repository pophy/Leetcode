package binarySearch;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindMinimumnRotatedSortedArray {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            int mid = left + (right - left) / 2;
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }
            if (nums[right] == nums[mid]) {
                right--;
                continue;
            }
            if (nums[mid] > nums[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[left] < nums[right] ? nums[left] : nums[right];
    }


    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        int left = -1;
        Map<Character, Integer> indexMap = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            left = Math.max(left, indexMap.getOrDefault(s.charAt(i), -1));
            count = Math.max(count, i - left);
            indexMap.put(s.charAt(i), i);
        }
        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> countMap = new HashMap(); //index -> count
        countMap.put(0,1);
        for (int i=0; i<nums.length; i++) {
            prefixSum += nums[i];
            if (countMap.get(prefixSum - goal) != null) {
                count += countMap.get(prefixSum - goal);
            }
            countMap.put(prefixSum, countMap.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        Set<Integer> window = new HashSet();
        Map<Integer,Integer> indexMap = new HashMap();
        int count = 0, left = 0, right = 0;
        while (right < nums.length) {
            while (right < nums.length && window.size() <= k) {
                window.add(nums[right]);
                indexMap.put(nums[right], right);
                if (window.size() == k) {
                    count++;
                }
                right++;
            }

            while (window.size() >= k) {
                if (indexMap.get(nums[left]) == left) {
                    window.remove(nums[left]);
                }
                if (window.size() == k) {
                    count++;
                }
                left++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        int[] m = {1, 2, 1, 2, 3};
        //System.out.println(findMin(m));
        System.out.println(subarraysWithKDistinct(m,2));
    }

}
