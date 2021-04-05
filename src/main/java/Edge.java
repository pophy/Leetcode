import java.util.ArrayList;

public class Edge {
	public int weight;
	public GraphNode from;
	public GraphNode to;

	public Edge(int weight, GraphNode from, GraphNode to) {
		this.weight = weight;
		this.from = from;
		this.to = to;
	}

}



class GraphNode {
	public int value;
	public int in;
	public int out;
	public ArrayList<GraphNode> nexts;
	public ArrayList<Edge> edges;

	public GraphNode(int value) {
		this.value = value;
		in = 0;
		out = 0;
		nexts = new ArrayList<>();
		edges = new ArrayList<>();
	}
}
