package search.dfs;


import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

public class TopViewOfTree {
    TreeMap<Integer, TreeInfo> map = new TreeMap<>();

    public int[] solve(Tree root) {
        dfs(root, 0, 0);
        int[] res = new int[map.size()];
        int i = 0;
        for (Map.Entry<Integer, TreeInfo> entry : map.entrySet()) {
            res[i++] = entry.getValue().tree.val;
        }
        return res;
    }

    private void dfs(Tree root, int level, int pos) {
        if (root == null) {
            return;
        }
        TreeInfo treeInfo = new TreeInfo(root, level, pos);
        if (map.get(pos) == null || map.get(pos).level > level) {
            map.put(treeInfo.pos, treeInfo);
        }
        dfs(root.left, level + 1, pos - 1);
        dfs(root.right, level + 1, pos + 1);
    }

    private static class TreeInfo {
        Tree tree;
        int level;
        int pos;

        public TreeInfo(Tree tree, int level, int pos) {
            this.tree = tree;
            this.level = level;
            this.pos = pos;
        }
    }

    public static class Tree {
        int val;
        Tree left;
        Tree right;

        public Tree(int val) {
            this.val = val;
        }
    }

    @Test
    public void test() {
        Tree tree1 = new Tree(1);
        Tree tree2 = new Tree(2);
        Tree tree3 = new Tree(3);
        Tree tree4 = new Tree(4);
        Tree tree5 = new Tree(5);
        Tree tree6 = new Tree(6);
        Tree tree7 = new Tree(7);

        tree1.left = tree2;
        tree1.right = tree3;
        tree2.right = tree4;
        tree4.right = tree5;
        tree5.right = tree6;
        tree6.right = tree7;

        System.out.println(solve(tree1));
    }

}
