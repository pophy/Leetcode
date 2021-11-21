package TwoPoints;

import org.junit.jupiter.api.Test;

import java.util.*;

public class MinWindowSubString {

//    public String minWindow(String s, String t) {
//        if (s.length() < t.length()) {
//            return "";
//        }
//        Map<Character, Integer> needMap = new HashMap();
//        int needCnt = 0;
//        for (Character c : t.toCharArray()) {
//            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
//            needCnt++;
//        }
//        int[] res = new int[2];
//        int minSize = Integer.MAX_VALUE;
//        int left = 0, right = 0;
//        while (right < s.length()) {
//            while (needCnt != 0 && right < s.length()) {
//                if (needMap.get(s.charAt(right)) != null) {
//                    if (needMap.get(s.charAt(right)) > 0) {
//                        needCnt--;
//                    }
//                    needMap.put(s.charAt(right), needMap.get(s.charAt(right)) - 1);
//                }
//                right++;
//            }
//            while (left < s.length() && needCnt == 0) {
//                if (right - left < minSize) {
//                    minSize = right - left;
//                    res = new int[]{left, right};
//                }
//                if (needMap.containsKey(s.charAt(left))) {
//                    needMap.put(s.charAt(left), needMap.get(s.charAt(left)) + 1);
//                    if (needMap.get(s.charAt(left)) > 0) {
//                        needCnt++;
//                    }
//                }
//                left++;
//            }
//        }
//        return s.substring(res[0], res[1]);
//    }

    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return "";
        }
        Map<Character, Integer> countMap = new HashMap<>();
        int neededCount = 0;
        for (char c : t.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            neededCount++;
        }
        int l = 0, r = 0, minLength = Integer.MAX_VALUE;
        String str = "";
        while (r < m) {
            while (neededCount != 0 && r < m) {
                char c = s.charAt(r);
                if (countMap.containsKey(c)) {
                    if (countMap.get(c) > 0) {
                        neededCount--;
                    }
                    countMap.put(c, countMap.get(c) - 1);
                }
                r++;
            }
            while (l < m && neededCount == 0) {
                if (r - l < minLength) {
                    minLength = r- l;
                    str = s.substring(l, r);
                }
                char c = s.charAt(l);
                if (countMap.containsKey(c)) {
                    countMap.put(c, countMap.get(c) + 1);
                    if (countMap.get(c) > 0) {
                        neededCount++;
                    }
                }
                l++;
            }
        }
        return str;
    }

//"cabwefgewcwaefgcf"
//"cae"
    @Test
    public void test() {
        System.out.println(minWindow("ewcwaefgcf", "cae"));
    }

}
