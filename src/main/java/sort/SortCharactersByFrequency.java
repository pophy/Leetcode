package sort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Input:
 * "tree"
 * <p>
 * Output:
 * "eert"
 */
public class SortCharactersByFrequency {

    public String solution(String str) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            countMap.put(str.charAt(i), countMap.getOrDefault(str.charAt(i), 0) + 1);
        }
        //bucket sort
        List<Character>[] buckets = new ArrayList[str.length() + 1];
        for (char c : countMap.keySet()) {
            int count = countMap.get(c);
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(c);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] == null) {
                continue;
            }
            for (char c : buckets[i]) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String str = "bbcddda";
        System.out.println(solution(str));
    }

}
