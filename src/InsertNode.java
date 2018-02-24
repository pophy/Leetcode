

/**
 * Created by Fei on 2/4/2018.
 */
public class InsertNode {

    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        TreeNode currentRoot = root;
        while (currentRoot != null) {
            if (currentRoot.val > node.val) {
                if (currentRoot.left != null) {
                    currentRoot = root.left;
                } else {
                    currentRoot.left = node;
                    break;
                }
            } else {
                if (currentRoot.right != null) {
                    currentRoot = currentRoot.right;
                } else {
                    currentRoot.right = node;
                    break;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        InsertNode insertNode = new InsertNode();
        TreeNode root1 = new TreeNode(1);
        TreeNode root = new TreeNode(2);
        TreeNode node = new TreeNode(3);
        root.left = root1;
        insertNode.insertNode(root,node);
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