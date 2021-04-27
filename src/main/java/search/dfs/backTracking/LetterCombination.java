package search.dfs.backTracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {

    private static final String[] KEYS = {"","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> combinations;

    public List<String> letterCombinations(String digits) {
        combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        doCombination(new StringBuilder(), digits, 0);
        return combinations;
    }

    private void doCombination(StringBuilder stringBuilder, String digits, int index) {
        if (index == digits.length()) {
            combinations.add(stringBuilder.toString());
            return;
        }
        char currentDigit = digits.charAt(index);
        int nextIndex = index+1;
        for (char c : KEYS[currentDigit - '0'].toCharArray()) {
            stringBuilder.append(c);
            doCombination(stringBuilder, digits, nextIndex);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    @Test
    public void test() {
        System.out.println(letterCombinations("23"));
    }

}
