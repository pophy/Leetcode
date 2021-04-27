package divideConquer;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryTree {


    /**
     * root(i)
     * <p>
     * left       right
     * [0 ~ n-1]
     */
    public List<Node> solution(int n) {
        return generate(1,n);
    }

    private List<Node> generate(int start, int end) {
        List<Node> res = new ArrayList<>();
        if (start < end) {
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<Node> leftList = generate(start, i - 1);
            List<Node> rightList = generate(i + 1, end);
            for (Node left : leftList) {
                for (Node right : rightList) {
                    Node root = new Node(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }


    private static class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

}
