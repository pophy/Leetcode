package TwoPoints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringConcatenationWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int n = words.length;
        if (n == 0) {
            return res;
        }
        int d = words[0].length();
        HashMap<String, Integer> countMap = new HashMap<>();
        for (String w : words) {
            countMap.put(w, countMap.getOrDefault(w, 0) + 1);
        }
        for (int j = 0; j < d; j++) {
            HashMap<String, Integer> hasWords = new HashMap<>();
            int num = 0;
            for (int i = j; i < s.length() - n * d + 1; i = i + d) {
                boolean hasRemoved = false;
                while (num < n) {
                    String word = s.substring(i + num * d, i + (num + 1) * d);
                    if (countMap.containsKey(word)) {
                        int value = hasWords.getOrDefault(word, 0);
                        hasWords.put(word, value + 1);
                        if (hasWords.get(word) > countMap.get(word)) {
                            hasRemoved = true;
                            int removeNum = 0;
                            while (hasWords.get(word) > countMap.get(word)) {
                                String firstWord = s.substring(i + removeNum * d, i + (removeNum + 1) * d);
                                hasWords.put(firstWord, hasWords.get(firstWord) - 1);
                                removeNum++;
                            }
                            num = num - removeNum + 1;
                            i = i + (removeNum - 1) * d;
                            break;
                        }
                    } else {
                        hasWords.clear();
                        i = i + num * d;
                        num = 0;
                        break;
                    }
                    num++;
                }
                if (num == n) {
                    res.add(i);
                }
                if (num > 0 && !hasRemoved) {
                    String firstWord = s.substring(i, i + d);
                    int v = hasWords.get(firstWord);
                    hasWords.put(firstWord, v - 1);
                    num = num - 1;
                }
            }
        }
        return res;
    }

}
