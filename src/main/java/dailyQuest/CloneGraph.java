package dailyQuest;

import org.testng.annotations.Test;

import java.util.*;

public class CloneGraph {

    Map<Node, Node> cloneMap = new HashMap<>();
    Set<Node> visited = new HashSet<>();

    public Node cloneGraph(Node node) {
        createCloneNode(node);
        visited.clear();
        setCloneNeighbors(node);
        return cloneMap.get(node);
    }

    private void createCloneNode(Node node) {
        if (visited.contains(node)) {
            return;
        }
        Node clone = new Node(node.val);
        cloneMap.put(node,clone);
        visited.add(node);
        for (Node neighbor: node.neighbors) {
            createCloneNode(neighbor);
        }
    }

    private void setCloneNeighbors(Node node) {
        if (visited.contains(node)) {
            return;
        }
        Node cloneNode = cloneMap.get(node);
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneMap.get(neighbor));
        }

        visited.add(node);
        for (Node neighbor: node.neighbors) {
            setCloneNeighbors(neighbor);
        }
    }

    @Test
    public void testCloneGraph() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node clone = cloneGraph(node1);
        System.out.println(clone);

    }


    private static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}
