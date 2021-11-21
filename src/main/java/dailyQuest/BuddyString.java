package dailyQuest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuddyString {

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.equals(goal)) {
            Set<Character> set = new HashSet();
            for (Character c : s.toCharArray()) {
                set.add(c);
            }
            if (set.size() < goal.length()) {
                return true;
            }
            return false;
        }
        List<Integer> diffIndexList = new ArrayList();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diffIndexList.add(i);
            }
        }
        if (diffIndexList.size() != 2) {
            return false;
        } else {
            boolean flag = true;
            if (s.charAt(diffIndexList.get(0)) != goal.charAt(diffIndexList.get(1))) {
                flag = false;
            }
            if (s.charAt(diffIndexList.get(1)) != goal.charAt(diffIndexList.get(0))) {
                flag = false;
            }
            return flag;
        }

    }

    @Test
    public void test() {
        String s1 = "aa";
        String s2 = "aa";

        System.out.println(buddyStrings(s1,s2));
    }


    @Test
    public void testSubString() {
        String abc = "1234567";
        System.out.println(abc.substring(3,4));
    }

}
