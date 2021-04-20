package Greedy;

import org.junit.jupiter.api.Test;

public class IsSubsequenceString {

    public boolean isSubSequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(isSubSequence("abc", "aebegce"));
    }

}
