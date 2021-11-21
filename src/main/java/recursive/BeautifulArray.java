package recursive;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class BeautifulArray {

    Map<Integer, int[]> memo = new HashMap();

    public int[] beautifulArray(int n) {
        memo.put(1, new int[]{1});
        return dfs(n);
    }

    private int[] dfs(int n) {
        if (memo.get(n) != null) {
            return memo.get(n);
        }
        int[] res = new int[n];
        int i = 0;
        for (int x : dfs((n + 1) / 2)) {
            res[i++] = 2 * x - 1;
        }
        for (int x : dfs(n / 2)) {
            res[i++] = 2 * x;
        }
        memo.put(n, res);
        return res;
    }

    @Test
    public void test() {
        System.out.println(beautifulArray(4));
    }
}
