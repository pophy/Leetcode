package search.bfs;

import org.junit.jupiter.api.Test;
import search.dfs.TopViewOfTree;

import java.util.*;

public class TopViewOfTreeBFS {

    public int[] solve(Tree root) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Queue<TreeInfo> queue = new LinkedList<>();
        queue.add(new TreeInfo(root, 0));
        while (!queue.isEmpty()) {
            TreeInfo current = queue.poll();
            if (map.get(current.pos) == null) {
                map.put(current.pos, current.tree.val);
            }
            if (current.tree.left != null) {
                queue.add(new TreeInfo(current.tree.left, current.pos - 1));
            }
            if (current.tree.right != null) {
                queue.add(new TreeInfo(current.tree.right, current.pos + 1));
            }
        }
        int[] res = new int[map.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res[i++] = entry.getValue();
        }
        return res;
    }

    private static class TreeInfo {
        Tree tree;
        int pos;

        public TreeInfo(Tree tree, int pos) {
            this.tree = tree;
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
