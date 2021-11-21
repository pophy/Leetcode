package TwoPoints;

import org.junit.jupiter.api.Test;

import java.util.*;

public class FindAllAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length(), n = p.length();
        if (m < n) {
            return new ArrayList();
        }
        List<Integer> res = new ArrayList<>();
        int[] pCount = new int[26];
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        int[] sCount = new int[26];
        for (int i = 0; i < m; i++) {
            char cur = s.charAt(i);
            sCount[cur - 'a']++;
            if (i >= n) {
                sCount[s.charAt(i - n) - 'a']--;
            }
            if (Arrays.equals(pCount, sCount)) {
                res.add(i - n);
            }
        }
        return res;
    }


    @Test
    public void test() {
        String s = "abab";
        String p = "ab";
        findAnagrams(s, p);
    }
}
