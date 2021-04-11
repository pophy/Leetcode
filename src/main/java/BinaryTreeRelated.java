import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class BinaryTreeRelated {


    //recursive - preorder - root -> left -> right
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node current = root;
        stack.push(current);
        while (!stack.isEmpty()) {
            if (current != null && current.left != null) {
                stack.push(current.left);
                current = current.left;
            } else {
                current = stack.pop();
                System.out.println(current.value);
                if (current.right != null) {
                    stack.push(current.right);
                    current = current.right;
                } else {
                    current = null;
                }
            }
        }
    }

    public static void inOrder2(Node root) {
        if (root == null) {
            return;
        }
        inOrder2(root.left);
        System.out.print(root.value + " ");
        inOrder2(root.right);
    }

    public static void bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.value + " ");
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static int getHeight(Node root) {
        int count = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            count++;
        }
        return count;
    }

    public static int getLength(Node root) {
        int length = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            length = Math.max(length, size);
        }
        return length;
    }

    public static Node revert(Node root) {
        if (root == null) {
            return null;
        }

        root.left = revert(root.right);
        root.right = revert(root.left);
        return root;
    }

    public Data isBinarySearchTree(Node root) {
        if (root == null) {
            return null;
        }
        Data leftData = isBinarySearchTree(root.left);
        Data rightData = isBinarySearchTree(root.right);
        int max = root.value;
        int min = root.value;
        if (leftData != null) {
            max = Math.max(max, leftData.max);
            min = Math.min(min, leftData.min);
        }
        if (rightData != null) {
            max = Math.max(max, rightData.max);
            min = Math.min(min, rightData.min);
        }
        boolean isSerachTree = true;
        if (leftData != null && leftData.max >= root.value) {
            isSerachTree = false;
        }
        if (rightData != null && rightData.max <= root.value) {
            isSerachTree = false;
        }

        return new Data(isSerachTree, min, max);
    }

    class Data {
        boolean isSearchTree;
        int max;
        int min;

        public Data(boolean isSearchTree, int max, int min) {
            this.isSearchTree = isSearchTree;
            this.max = max;
            this.min = min;
        }
    }

    public BalancedTreeData isBalancedTree(Node root) {
        if (root == null) {
            return new BalancedTreeData(0, true);
        }
        BalancedTreeData leftData = isBalancedTree(root.left);
        BalancedTreeData rightData = isBalancedTree(root.right);

        int height = Math.max(leftData.height, rightData.height);
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced && (Math.abs(leftData.height - rightData.height) < 2);
        return new BalancedTreeData(height, isBalanced);
    }

    class BalancedTreeData {
        int height;
        boolean isBalanced;

        public BalancedTreeData(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public void serialize(Node root, StringBuilder sb) { //preorder
        if (root == null) {
            sb.append("#_");
            return;
        }
        //preorder
        sb.append(root.value + "_");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    public Node deSerialize(String str) {
        String[] arr = str.split("_");
        Queue queue = new LinkedList(Arrays.asList(arr));
        return rebuildTree(queue);
    }

    public Node rebuildTree(Queue<String> queue) {
        String value = queue.poll();
        if ("#".equals(value)) {
            return null;
        }
        Node root = new Node(Integer.valueOf(value));
        root.left = rebuildTree(queue);
        root.right = rebuildTree(queue);
        return root;
    }

    public Node getCommonAncestor(Node root, Node o1, Node o2) {
        if (root == null || root == o1 || root == o2) {
            return root;
        }
        Node left = getCommonAncestor(root.left, o1, o2);
        Node right = getCommonAncestor(root.right, o1, o2);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    public ReturnType maxDistanceInTree(Node root) {
        if (root == null) {
            return new ReturnType(0, 0);
        }
        ReturnType left = maxDistanceInTree(root.left);
        ReturnType right = maxDistanceInTree(root.right);
        int maxDistance = Math.max(left.maxDistance, right.maxDistance);
        maxDistance = Math.max(maxDistance, left.h + right.h + 1);
        int height = Math.max(left.h, right.h) + 1;
        return new ReturnType(maxDistance, height);
    }


    public int numberOfTree(int n, int[] cache) {
        if (n == 0 || n == 1) {
            cache[n] = 1;
            return 1;
        }
        if (n == 2) {
            cache[n] = 2;
            return 2;
        }
        if (cache[n] != -1) {
            return cache[n];
        }
        int count = 0;
        for (int i = 0; i <= n - 1; i++) {
            count += numberOfTree(i, cache) * numberOfTree(n - i - 1, cache);
        }
        cache[n] = count;
        return count;
    }

    /**
     * 二叉树每个结点都有一个int型权值，给定一棵二叉树，要求计算出从根结点到 叶结点的所有路径中，权值和最大的值为多少。
     */

    public int maxPath(Node root) {
        return dfs(root, 0);
    }

    public int maxPath2(Node root) {
        return maxPathHelper(root);
    }

    //以X为头的树， maxPath
    private int maxPathHelper(Node x) {
        if (x.left == null && x.right == null) {
            return x.value;
        }
        int next = Integer.MIN_VALUE;
        if (x.left != null) {
            next = maxPathHelper(x.left);
        }
        if (x.right != null) {
            next = Math.max(next,maxPathHelper(x.right));
        }
        return next + x.value;
    }

    private int dfs(Node root, int sum) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (root.left == null && root.right == null) {
            return  sum + root.value;
        }
        int left = dfs(root.left, sum + root.value);
        int right = dfs(root.right, sum + root.value);
        return Math.max(left, right);
    }


    public static class ReturnType {
        public int maxDistance;
        public int h;

        public ReturnType(int m, int h) {
            this.maxDistance = m;
            ;
            this.h = h;
        }
    }


    private static Node createTestNode() {
        Node root = new Node(10);
        Node node5 = new Node(5);
        Node node15 = new Node(15);
        root.left = node5;
        root.right = node15;

        Node node3 = new Node(3);
        Node node6 = new Node(6);
        node5.left = node3;
        node5.right = node6;

        Node node1 = new Node(1);
        Node node4 = new Node(4);
        node3.left = node1;
        node3.right = node4;

        Node node13 = new Node(13);
        Node node17 = new Node(17);
        node15.left = node13;
        node15.right = node17;

        Node node11 = new Node(11);
        Node node14 = new Node(14);
        node13.left = node11;
        node13.right = node14;
        return root;
    }


    @Test
    public static void testPreOrder() {
        preOrder(createTestNode());
    }

    @Test
    public static void testInOrder() {
        inOrder2(createTestNode());
    }

    @Test
    public static void testBfs() {
        bfs(createTestNode());
    }

    @Test
    public static void testGetHeight() {
        System.out.println(getHeight(createTestNode()));
    }

    @Test
    public static void testGetLength() {
        System.out.println(getLength(createTestNode()));
    }

    @Test
    public static void testRevert() {
        Node root = createTestNode();
        Node node = revert(root);
        inOrder(node);
    }

    @Test
    public static void test10() {
        BinaryTreeRelated related = new BinaryTreeRelated();
        System.out.println(related.isBinarySearchTree(createTestNode()).isSearchTree);
    }

    @Test
    public void test11() {
        BinaryTreeRelated related = new BinaryTreeRelated();
        System.out.println(related.isBalancedTree(createTestNode()).isBalanced);
    }

    @Test
    public void test12() {
        BinaryTreeRelated related = new BinaryTreeRelated();
        Node root = createTestNode();
        preOrder(root);
        StringBuilder sb = new StringBuilder();
        related.serialize(root, sb);
//        System.out.println(sb.toString());
        System.out.println("===================================");
        root = deSerialize(sb.toString());
        preOrder(root);

    }

    @Test
    public void test13() {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        head.right.right.left = new Node(8);

        Node o1 = head.right.right.left;
        Node o2 = head.right.left;

        System.out.println("ancestor : " + getCommonAncestor(head, o1, o2).value);
    }

    @Test
    public void test14() {
        Node head2 = new Node(1);
        head2.left = new Node(2);
        head2.right = new Node(3);
        head2.right.left = new Node(4);
        head2.right.right = new Node(5);
        head2.right.left.left = new Node(6);
        head2.right.right.right = new Node(7);
        head2.right.left.left.left = new Node(8);
        head2.right.right.right.right = new Node(9);
        System.out.println(maxDistanceInTree(head2).maxDistance);
    }

    public static int numTrees(int n) {
        if (n < 2) {
            return 1;
        }
        int[] num = new int[n + 1];
        num[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                num[i] += num[j - 1] * num[i - j];
            }
        }
        return num[n];
    }

    @Test
    public void test15() {
        long start = System.nanoTime();
        int[] cache = new int[16];
        for (int i = 0; i < 16; i++) {
            cache[i] = -1;
        }
        System.out.println(numberOfTree(15, cache));
        long end = System.nanoTime();
        System.out.println("Method 1: " + (end - start));
        start = System.nanoTime();
        System.out.println(numTrees(15));
        end = System.nanoTime();
        System.out.println("Method 2: " + (end - start));
    }

    @Test
    public void test16() {
        Node root = createTestNode();
        System.out.println(maxPath(root));
        System.out.println(maxPath2(root));
    }

}


class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}