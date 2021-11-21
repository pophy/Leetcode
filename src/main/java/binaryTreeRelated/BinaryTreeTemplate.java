package binaryTreeRelated;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeTemplate {

    List<List<TreeNode>> result = new ArrayList<>();
    List<List<Integer>> pathSumResult = new ArrayList<>();
    int count = 0;

    public void dfs(TreeNode root, LinkedList<TreeNode> path) {
        if (root == null) {
            return;
        }
        path.add(root);
        if (root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));

        } else {
            dfs(root.left, path);
            dfs(root.right, path);
        }
        path.removeLast(); //back tracking
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        pathSumHelper(root, targetSum);
        return count;
    }

    public void pathSumHelper(TreeNode root, int targetSum) {
        if (root == null) {
            return ;
        }
        pathSumDFS(root, new LinkedList<>(), targetSum);
        pathSumHelper(root.left, targetSum);
        pathSumHelper(root.right, targetSum);
        return;
    }

    public void pathSumDFS(TreeNode root, LinkedList<TreeNode> path, int targetSum) {
        if (root == null) {
            return;
        }
        path.add(root);
        targetSum = targetSum - root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            count++;
        } else {
            pathSumDFS(root.left, path, targetSum);
            pathSumDFS(root.right, path, targetSum);
        }
        path.removeLast(); //back tracking
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tempList = new ArrayList();
            for (int i=0; i<size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                tempList.add(current.val);
            }
            result.add(tempList);
        }
        return result;
    }


//    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//        LinkedList<TreeNode> path = new LinkedList<>();
//        pathSumDFS(root,path, targetSum);
//        return pathSumResult;
//    }

//    public void pathSumDFS(TreeNode root, LinkedList<TreeNode> path, int targetSum) {
//        if (root == null) {
//            return;
//        }
//        path.add(root);
//        targetSum = targetSum - root.val;
//        if (root.left == null && root.right == null && targetSum == 0) {
//            List<Integer> temp = new ArrayList<>();
//            for (TreeNode node : path) {
//                temp.add(node.val);
//            }
//            pathSumResult.add(temp);
//
//        } else {
//            pathSumDFS(root.left, path, targetSum);
//            pathSumDFS(root.right, path, targetSum);
//        }
//        path.removeLast(); //back tracking
//    }

    @Test
    public void test() {
//        TreeNode root = createTestNode();
//        List<List<Integer>> res = pathSum(root, 10);
//        for (List<Integer> list : res) {
//            list.forEach(n -> System.out.print(n + " -> "));
//            System.out.print("\t\n");
//        }

    }


    private static TreeNode createTestNode() {
//        TreeNode root = new TreeNode(10);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node15 = new TreeNode(15);
//        root.left = node5;
//        root.right = node15;
//
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node6 = new TreeNode(6);
//        node5.left = node3;
//        node5.right = node6;
//
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node4 = new TreeNode(4);
//        node3.left = node1;
//        node3.right = node4;
//
//        TreeNode node13 = new TreeNode(13);
//        TreeNode node17 = new TreeNode(17);
//        node15.left = node13;
//        node15.right = node17;
//
//        TreeNode node11 = new TreeNode(11);
//        TreeNode node14 = new TreeNode(14);
//        node13.left = node11;
//        node13.right = node14;

        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);

        root.left = root2;
        root2.left = root3;
        root.right = root4;
        root4.right = root5;


        return root;
    }

}
