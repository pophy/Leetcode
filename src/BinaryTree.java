import java.util.ArrayList;
import java.util.List;

/**
 * Created by fei on 1/4/18.
 */
public class BinaryTree {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> resultList = new ArrayList<>();
        if (root.left != null) {
            List<Integer> list = inorderTraversal(root.left);
            resultList.addAll(list);
        }
        if (root.right != null) {
            List<Integer> list = inorderTraversal(root.right);
            resultList.addAll(list);
        }

        return resultList;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        tree.inorderTraversal(root);
    }

}


   class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }