package TwoPoints;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class LongestWordWithoutRepeat {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0, right = 0;
        Set<Character> window = new HashSet();
        int count = Integer.MIN_VALUE;
        while (right < s.length()) {
            while (right < s.length() && !window.contains(s.charAt(right))) {
                window.add(s.charAt(right));
                right++;
                count = Math.max(count, window.size());
            }
            while (right < s.length() && s.charAt(left) != s.charAt(right)) {
                window.remove(s.charAt(left));
                left++;
            }
            left++;
            right++;

        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("p"));
    }

}
