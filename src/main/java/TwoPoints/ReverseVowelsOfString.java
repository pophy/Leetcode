package TwoPoints;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

public class ReverseVowelsOfString {

    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));


    /**
     * Given s = "leetcode", return "leotcede".
     */

    public String solution(String word) {
        char[] array = word.toCharArray();
        int l = 0;
        int r = word.length() - 1;
        while (l < r) {
            if (vowels.contains(array[l]) && vowels.contains(array[r])) {
                swap(array,l++,r--);
            }
            if (!vowels.contains(array[l])){
                l++;
            }
            if (!vowels.contains(array[r])) {
                r--;
            }
        }
        return String.valueOf(array);
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Test
    public void test() {
        System.out.println(solution("LeetCode"));
    }

}
