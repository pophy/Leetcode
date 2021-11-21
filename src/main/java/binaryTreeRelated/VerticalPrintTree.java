package binaryTreeRelated;

import org.junit.jupiter.api.Test;

import java.util.*;

public class VerticalPrintTree {

    TreeMap<Integer, List<Info>> map;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new TreeMap<>();
        dfs(root, 0, 0);
        List<List<Integer>> result = new ArrayList();
        for (int key : map.keySet()) {
            List<Integer> list = new ArrayList();
            List<Info> tempList = map.get(key);
            Collections.sort(tempList, (a, b) -> a.level == b.level ? a.node.val - b.node.val : a.level - b.level);
            for (Info info : map.get(key)) {
                list.add(info.node.val);
            }
            result.add(list);
        }
        return result;
    }

    private void dfs(TreeNode root, int level, int pos) {
        if (root == null) {
            return;
        }
        if (map.get(pos) == null) {
            map.put(pos, new ArrayList<Info>());
        }
        map.get(pos).add(new Info(root, level, pos));
        dfs(root.left, level + 1, pos - 1);
        dfs(root.right, level + 1, pos + 1);
    }

    private static class Info {
        TreeNode node;
        int level;
        int pos;

        public Info(TreeNode node, int level, int pos) {
            this.node = node;
            this.level = level;
            this.pos = pos;
        }
    }


    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);


        node1.left = node2;
        node1.right = node3;
        node3.left = node6;
        node3.right = node7;

        verticalTraversal(node1);
    }

}
