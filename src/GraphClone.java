import pojo.Node;

import java.util.*;

public class GraphClone {

    public static Node deepClone(Node node){
       // Map<Node,Node> aggregateMap = new HashMap<Node, Node>();
        Queue<Node> queue = new LinkedList();
        queue.add(node);
        Node copyNode = new Node(node.getId() + " copy");
        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            queue.addAll(currentNode.getNeighbors());
            for (Node neighbor:currentNode.getNeighbors()) {
                Node copyNeighbor = new Node(neighbor.getId() + " copy");
                copyNode.getNeighbors().add(copyNeighbor);
            }
        }


  
  
       return copyNode;
    }

    
    public static void main (String[] args ) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        a.getNeighbors().add(b);
        a.getNeighbors().add(c);
        b.getNeighbors().add(d);
        b.getNeighbors().add(e);
        deepClone(a);
        System.out.println(a);
    }
}
