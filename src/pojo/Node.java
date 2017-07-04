package pojo;

import java.util.Vector;

public class Node {
    
    private Vector<Node> neighbors = new Vector<Node>();
    private String id;

    public Node(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Vector<Node> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(Vector<Node> neighbors) {
        this.neighbors = neighbors;
    }
}
