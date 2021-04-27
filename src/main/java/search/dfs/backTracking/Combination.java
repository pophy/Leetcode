package search.dfs.backTracking;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 1,2,3
 * 1,2
 * 1,3
 * 2,3
 */
public class Combination {

    List<List<Integer>> res;


    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, path, 1);
        return res;
    }

    private void dfs(int n, int k, Deque<Integer> path, int index) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <= n; i++) {
            // 向路径变量里添加一个数
            path.addLast(i);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            dfs(n, k, path, i + 1);
            // 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
            path.removeLast();
        }
    }

    @Test
    public void test() {
        combine(4, 2).stream().forEach(l -> {
            System.out.println(l);
        });
    }
}
