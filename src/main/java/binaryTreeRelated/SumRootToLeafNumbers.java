package binaryTreeRelated;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class SumRootToLeafNumbers {

    int res = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> path = new LinkedList();
        dfs(root, path);
        return res;
    }


    public void dfs(TreeNode root, LinkedList<TreeNode> path) {
        if (root == null) {
            return;
        }
        path.add(root);
        if (root.left == null && root.right == null) {
            int temp = 0;
            for (int i = 0; i<path.size(); i++) {
                temp = temp * 10 + path.get(i).val;
            }
            res += temp;
        } else {
            dfs(root.left, path);
            dfs(root.right, path);
        }
        path.removeLast();
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;

        System.out.println(sumNumbers(node1));
        LinkedList list = new LinkedList();

    }

}
