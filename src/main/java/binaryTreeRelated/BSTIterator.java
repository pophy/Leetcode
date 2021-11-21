package binaryTreeRelated;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

public class BSTIterator {

    Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new LinkedList();
        stack.push(root);
        while (root != null && root.left != null) {
            stack.push(root.left);
            root = root.left;
        }

    }

    public int next() {
        TreeNode current = stack.pop();
        int val = current.val;
        if (current.right != null) {
            current = current.right;
            stack.push(current);
            while (current != null && current.left != null) {
                stack.push(current.left);
                current = current.left;
            }
        }
        return val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private static TreeNode createTestNode() {
        TreeNode root = new TreeNode(7);
        TreeNode node3 = new TreeNode(3);
        TreeNode node15 = new TreeNode(15);
        root.left = node3;
        root.right = node15;

        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        node15.left = node9;
        node15.right = node20;

        return root;
    }


    public static void main(String args[]) {
        TreeNode node = createTestNode();
        BSTIterator iterator = new BSTIterator(node);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());



    }
    
}
