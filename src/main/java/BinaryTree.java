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


}