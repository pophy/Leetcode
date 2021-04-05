import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    List<String> result = new ArrayList<String>();
    boolean[] used = new boolean[100];

    public List<String> getAllPermutations(String strs) {
        result.clear();
        List<Character> path = new ArrayList<Character>();
        helper(strs.toCharArray(), path);
        return result;
    }

    public List<String> getAllPermutationsWithDup(String str) {
        result.clear();
        List<Character> path = new ArrayList<Character>();
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        helper3(chars, path);
        return result;
    }

    private void helper3(char[] toCharArray, List<Character> path) {
        if (path.size() == toCharArray.length) {
            result.add(String.valueOf(path));
        }
        for (int i = 0; i < toCharArray.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && toCharArray[i] == toCharArray[i - 1] && used[i - 1]) {
                continue;
            }
            used[i] = true;
            path.add(toCharArray[i]);
            helper3(toCharArray, path);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }


    public List<String> getCombination(String str) {
        result.clear();
        //call dfs
        List<Character> path = new ArrayList<Character>();
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        helper2(chars, path, 0);
        return result;
    }

    public List<String> getCombinationWithDup(String str) {
        result.clear();
        //call dfs
        List<Character> path = new ArrayList<Character>();
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        helper3(chars, path, 0);
        return result;
    }

    private void helper3(char[] chars, List<Character> path, int index) {
        result.add(String.valueOf(path));
        for (int i = index; i < chars.length; i++) {
            if (i > index && chars[i] == chars[i - 1]) {
                continue;
            }
            path.add(chars[i]);
            helper3(chars, path, index + 1);
            path.remove(path.size() - 1);
        }
    }

    private void helper2(char[] chars, List<Character> path, int index) {
        result.add(String.valueOf(path));
        for (int i = index; i < chars.length; i++) {
            path.add(chars[i]);
            helper2(chars, path, i + 1);
            path.remove(path.size() - 1);
        }

    }

    private void helper(char[] chars, List<Character> path) {
        //base case
        if (path.size() == chars.length) {
            result.add(String.valueOf(path));
        }

        for (int i = 0; i < chars.length; i++) {
            if (path.contains(chars[i])) {
                continue;
            }
            path.add(chars[i]);
            helper(chars, path);
            path.remove(path.size() - 1);
        }
    }

    public int getCountOfCombinations(String str) {
        char[] arr = str.toCharArray();
        return process(arr,0);
    }

    private int process(char[] chs, int i) {
        if (i == chs.length) {
            return 1;
        }
        if (chs[i] == '0') {
            return 0;
        }
        if (chs[i] == '1') {
            int res = process(chs, i + 1);
            if (i + 1 < chs.length) {
                res += process(chs, i + 2);
            }
            return res;
        }
        if (chs[i] == '2') {
            int res = process(chs, i + 1);
            if (i + 1 < chs.length && (chs[i + 1] >= '0' && chs[i + 1] <= '6')) {
                res += process(chs, i + 2);
            }
            return res;
        }
        return process(chs, i + 1);
    }


    @Test
    public void test1() {
        getAllPermutations("abc").stream().forEach(a -> {
            System.out.println(a);
        });
    }

    @Test
    public void test2() {
        getCombination("abc").stream().forEach(a -> {
            System.out.println(a);
        });
    }

    @Test
    public void test3() {
        getAllPermutationsWithDup("abca").stream().forEach(a -> {
            System.out.println(a);
        });
    }

    @Test
    public void test4() {
        getCombinationWithDup("aaa").stream().forEach(a -> {
            System.out.println(a);
        });
    }
}
