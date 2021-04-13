public class BSTToLinkedList {

    public Node solution(Node head) {
        return process(head).left;
    }

    public ReturnType process(Node root) {
        if (root == null) {
            return new ReturnType(null, null);
        }
        ReturnType leftReturn = process(root.left);
        ReturnType rightReturn = process(root.right);
        if (leftReturn.left != null) {
            root.left = leftReturn.right;
            leftReturn.right = root;
        }
        if (rightReturn.right != null) {
            rightReturn.left = root;
            root.right = rightReturn.left;
        }
        Node left = leftReturn.left != null ? leftReturn.left : root;
        Node right = rightReturn.right != null ? rightReturn.right : root;
        return new ReturnType(left, right);
    }

    private class ReturnType {
        Node left;
        Node right;

        public ReturnType(Node left, Node right) {
            this.left = left;
            this.right = right;
        }
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

}
