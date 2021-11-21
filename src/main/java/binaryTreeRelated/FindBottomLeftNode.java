package binaryTreeRelated;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class FindBottomLeftNode {


    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        int res = -1;
        while (!queue.isEmpty()) {
            res = queue.peekFirst().val;
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return res;
    }


    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;

        System.out.println(findBottomLeftValue(node1));


    }
}
