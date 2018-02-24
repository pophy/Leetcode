import java.util.Stack;

/**
 * Created by Fei on 2/4/2018.
 */
public class BinaryTree {

    private void inorderPrint(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
                while (node != null) {
                    stack.push(node.right);
                    node = node.right;
                }
            }
        }
    }

    public static void main(String args[]) {


    }

}
