package TwoPoints;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class MaxNumOfVowelsInGivenLength {
    static Set<Character> set = new HashSet();

    static {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
    }

    public int maxVowels(String s, int k) {
        int n = s.length();
        if (k > n) {
            k = n;
        }
        int vowelsInWindow = 0;

        int max = vowelsInWindow;
        for (int i = k; i < n; i++) {
            if (i < k && set.contains(s.charAt(i - k))) {
                vowelsInWindow--;
            }
            if (set.contains(s.charAt(i))) {
                vowelsInWindow++;
            }
            max = Math.max(max, vowelsInWindow);
        }
        return max;
    }

    @Test
    public void test() {
        String s = "tryhard";
        System.out.println(maxVowels(s, 4));
    }
}
