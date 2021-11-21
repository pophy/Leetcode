package monoStackRelated;

import org.junit.jupiter.api.Test;

import java.util.*;

public class RemoveDupLetterSmallest {

    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Set<Character> visited = new HashSet<>();
        Map<Character, Integer> countMap = new HashMap();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        LinkedList<Character> stack = new LinkedList();
        for (char c : s.toCharArray()) {
            if (visited.contains(c)) {
                countMap.put(c, countMap.get(c) - 1);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c) {
                char pre = stack.peek();
                if (countMap.get(pre) > 1) {
                    stack.pop();
                    countMap.put(pre, countMap.get(pre) - 1);
                    visited.remove(pre);
                } else {
                    break;
                }
            }
            stack.push(c);
            visited.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = stack.size() - 1; i >= 0; i--) {
            sb.append(stack.get(i));
        }
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(removeDuplicateLetters("bbcaac"));
    }
}
