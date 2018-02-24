import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Fei on 2/5/2018.
 */
public class Permutation {

    List<String> result = new ArrayList<String>();
    boolean[] used = new boolean[100];

    private List<String> permutation(char[] strs) {
        result.clear();
        List<Character> path = new ArrayList<Character>();
        helper(strs,path);
        return result;
    }

    private void helper(char[] strs, List<Character> path) {
        if (path.size() == strs.length) {
            StringBuffer sb = new StringBuffer();
            for (Character c : path) {
                sb.append(c);
            }
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < strs.length; i++) {
            if (path.contains(strs[i])) {
                continue;
            }
            path.add(strs[i]);
            helper(strs,path);
            path.remove(path.size() - 1);
        }
    }

    private List<String> permutationWithDup(char[] strs) {
        result.clear();
        Arrays.sort(strs);
        helperWithDup(strs,new ArrayList<Character>());
        return result;
    }

    private void helperWithDup(char[] strs, List<Character> path) {
        if (strs.length == path.size()) {
            StringBuffer sb = new StringBuffer();
            for (Character c : path) {
                sb.append(c);
            }
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < strs.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && strs[i] == strs[i - 1] && !used[i-1]) {
                continue;
            }
            used[i] = true;
            path.add(strs[i]);
            helperWithDup(strs, path);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }


    private List<String> subset(char[] strs) {
        result.clear();
        subsetHelper(strs,new ArrayList<Character>(),0);
        return result;
    }

    private void subsetHelper(char[] strs, List<Character> path, int index) {
        StringBuffer sb = new StringBuffer();
        for (Character c : path) {
            sb.append(c);
        }
        result.add(sb.toString());

        for (int i = index; i < strs.length; i++) {
            path.add(strs[i]);
            subsetHelper(strs, path, i + 1);
            path.remove(path.size() - 1);
        }

    }

    private List<String> subsetWithDup(char[] strs) {
        result.clear();
        Arrays.sort(strs);
        subsetHelperWithDup(strs, new ArrayList<Character>(), 0);
        return result;
    }

    private void subsetHelperWithDup(char[] strs, List<Character> path, int index) {
        StringBuffer sb = new StringBuffer();
        for (Character c : path) {
            sb.append(c);
        }
        result.add(sb.toString());

        for (int i = index; i < strs.length; i++) {
            if (i > index && strs[i -1] == strs[i]) {
                continue;
            }
            path.add(strs[i]);
            subsetHelper(strs, path, i + 1);
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        char[] ds = {'a','b','c','d'};
        permutation.permutation(ds);
        char[] ds1 = {'a','b','c','a'};
        permutation.permutationWithDup(ds1);
        permutation.subset(ds1);
    }

}
