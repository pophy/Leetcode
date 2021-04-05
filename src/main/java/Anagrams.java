import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fei on 2/9/2018.
 */
public class Anagrams {
    public List<String> anagrams(String[] strs) {

        boolean[] used = new boolean[strs.length];

        List<String> result = new ArrayList<String>();
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                AnagramItem word1 = new AnagramItem(strs[i]);
                AnagramItem word2 = new AnagramItem(strs[j]);
                if (word1.equals(word2)) {
                    if (!used[i]) {
                        used[i] = true;
                        result.add(word1.word);
                    }
                    if (!used[j]) {
                        used[j] = true;
                        result.add(word2.word);
                    }
                }
            }
        }
        return result;
    }


    private class AnagramItem {
        String word;

        public AnagramItem(String w) {
            word = w;
        }

        @Override
        public boolean equals(Object o) {

            AnagramItem testItem = (AnagramItem) o;
            if (word.length() != testItem.word.length()) {
                return false;
            }
            int[] dict = new int[26];
            for (int i = 0; i < word.length(); i++) {
                dict[word.charAt(i) - 'a']++;
            }
            for (int i = 0; i < testItem.word.length(); i++) {
                dict[testItem.word.charAt(i) - 'a']--;
                if (dict[testItem.word.charAt(i) - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Anagrams anagrams = new Anagrams();
        String[] ds = {"",""};
        anagrams.anagrams(ds);
    }
}
