package binaryTreeRelated;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isBST(root).isBST;
    }

    private ReturnType isBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        int min = root.val;
        int max = root.val;
        boolean isBST = true;

        ReturnType left = isBST(root.left);
        ReturnType right = isBST(root.right);

        if (left != null) {
            max = Math.max(max,left.max);
            min = Math.min(min,left.min);
            if (!left.isBST || left.max >= root.val) {
                isBST = false;
            }
        }
        if (right != null) {
            min = Math.min(min,right.min);
            max = Math.max(max,right.max);
            if (!right.isBST || right.min <= root.val) {
                isBST = false;
            }
        }
        return new ReturnType(isBST,min,max);
    }


    private static class ReturnType {
        boolean isBST;
        int min;
        int max;

        public ReturnType(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }
}
