package search.dfs.backTracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {

    List<String> result;

    public List<String> subSet(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        result = new ArrayList<>();
        List<Character> path = new ArrayList<>();
        dfs(chars, path, 0);
        return result;
    }

    private void dfs(char[] chars, List<Character> path, int index) {
        StringBuilder sb = new StringBuilder();
        for (Character c : path) {
            sb.append(c);
        }
        result.add(sb.toString());
        for (int i = index; i < chars.length; i++) {
            if (i > 1 && chars[i] == chars[i-1]) {
                continue;
            }
            path.add(chars[i]);
            dfs(chars, path, i + 1);
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test() {
        subSet("112").stream().forEach(p -> System.out.println(p));
    }

}
