import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Fei on 2/14/2018.
 */
public class Solution {

    List<String> result = new ArrayList();

    public List<String> generateParenthesis(int n) {
        result.clear();
        if (n < 1) {
            return result;
        }

        List<Character> path = new ArrayList();
        dfs(n, path, 0,0);
        return result;
    }

    private void dfs(int n, List<Character> path, int left, int right) {
        if (left == n && right == n) {
            StringBuffer sb = new StringBuffer();
            for (Character c : path) {
                sb.append(c);
            }
            result.add(sb.toString());
            return;
        }
        if (left < n) {
            path.add('(');
            dfs(n,path,left + 1, right);
            path.remove(path.size() -  1);
        }
        if (right < left) {
            path.add(')');
            dfs(n,path,left, right + 1);
            path.remove(path.size() -  1);
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generateParenthesis(3);
    }

}
