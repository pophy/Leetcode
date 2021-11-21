package binaryTreeRelated;

import org.junit.jupiter.api.Test;

public class MaxPathSum {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }


    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);

        max = Math.max(max, left + right + root.val);
        return left + right + root.val;
    }


    @Test
    public void test() {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(-1);
        TreeNode node3 = new TreeNode(3);

        node1.left = node2;
//        node1.right = node3;
        maxPathSum(node1);
    }
}
