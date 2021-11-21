package search.dfs;

import org.junit.jupiter.api.Test;

public class JumpGameV {

    int n;
    int[] memo;

    public int maxJumps(int[] arr, int d) {
        n = arr.length;
        memo = new int[n];
        int res = 1;
        for (int i = 0; i < n; i++) {
            int temp = dfs(arr, i, d);
            res = Math.max(temp, res);
        }
        return res;
    }

    private int dfs(int[] arr, int cur, int d) {
        if (memo[cur] != 0) {
            return memo[cur];
        }
        int res = 1;
        for (int i = cur + 1; i <= Math.min(cur + d, n - 1) && arr[cur] > arr[i]; i++) {
            res = Math.max(res, dfs(arr, i, d) + 1);
        }
        for (int i = cur - 1; i >= Math.max(cur - d, 0) && arr[cur] > arr[i]; i--) {
            res = Math.max(res, dfs(arr, i, d) + 1);
        }
        memo[cur] = res;
        return res;
    }

    @Test
    public void test() {
        int[] nums = {14, 6, 8, 13, 9, 7, 10, 6, 12};
        System.out.println(maxJumps(nums, 2));
    }
}
