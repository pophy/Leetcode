package pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by fei on 7/29/17.
 */
public class LongestSubString {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcdb"));

    }

}
