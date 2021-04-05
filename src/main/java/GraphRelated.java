import org.testng.annotations.Test;

import java.util.*;

public class GraphRelated {

    //no loop && direction graph
    public List<GraphNode> topoLogySort(Graph graph) {
        List<GraphNode> result = new ArrayList<>();
        Map<GraphNode, Integer> inMap = new HashMap<>();
        //find all nodes with in-degree == 0
        Queue<GraphNode> queue = new LinkedList<>();
        for (GraphNode node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            GraphNode current = queue.poll();
            result.add(current);
            List<GraphNode> nexts = current.nexts;
            for (GraphNode n : nexts) {
                inMap.put(n, inMap.get(n) - 1);
                if (inMap.get(n) == 0) {
                    queue.add(n);
                }
            }
        }
        return result;
    }

    public Map<GraphNode, Integer> dijkstra(GraphNode node) {
        Map<GraphNode, Integer> distanceMap = new HashMap<>();
        distanceMap.put(node, 0);
        Set<GraphNode> visited = new HashSet<>();
        GraphNode minNode = getMinDistanceWithUnvisitedNote(distanceMap, visited);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                GraphNode toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                }
                distanceMap.put(toNode, Math.min(distanceMap.get(toNode), distance + edge.weight));
            }
            visited.add(minNode);
            minNode = getMinDistanceWithUnvisitedNote(distanceMap, visited);
        }
        return distanceMap;
    }

    private GraphNode getMinDistanceWithUnvisitedNote(Map<GraphNode, Integer> distanceMap, Set<GraphNode> visited) {
        GraphNode minNode = null;
        int minDistance = Integer.MIN_VALUE;
        for (Map.Entry<GraphNode, Integer> entry : distanceMap.entrySet()) {
            GraphNode node = entry.getKey();
            int distance = entry.getValue();
            if (!visited.contains(node) && distance < minDistance) {
                minDistance = distance;
                minNode = node;
            }
        }

        return minNode;
    }


    public static Graph generateTestGraph() {
        Graph graph = new Graph();

        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        GraphNode node5 = new GraphNode(5);
        GraphNode node6 = new GraphNode(6);

        Edge edge1 = new Edge(1, node1, node2);
        Edge edge2 = new Edge(1, node2, node3);
        Edge edge3 = new Edge(1, node2, node4);
        Edge edge4 = new Edge(1, node3, node4);
        Edge edge5 = new Edge(1, node4, node5);
        Edge edge6 = new Edge(1, node4, node6);
        Edge edge7 = new Edge(1, node5, node6);

        node1.edges.add(edge1);
        node1.nexts.add(node2);

        node2.edges.add(edge2);
        node2.edges.add(edge3);
        node2.nexts.add(node3);
        node2.nexts.add(node4);

        node3.edges.add(edge4);
        node3.nexts.add(node4);

        node4.edges.add(edge5);
        node4.edges.add(edge6);
        node4.nexts.add(node5);
        node4.nexts.add(node6);

        node5.edges.add(edge7);
        node5.nexts.add(node6);

        graph.nodes.put(1, node1);
        graph.nodes.put(2, node2);
        graph.nodes.put(3, node3);
        graph.nodes.put(4, node4);
        graph.nodes.put(5, node5);
        graph.nodes.put(6, node6);

        graph.edges.add(edge1);
        graph.edges.add(edge2);
        graph.edges.add(edge3);
        graph.edges.add(edge4);
        graph.edges.add(edge5);
        graph.edges.add(edge6);
        graph.edges.add(edge7);
        return graph;
    }

    @Test
    public void test() {
        Graph graph = generateTestGraph();
        List<GraphNode> result = topoLogySort(graph);
        result.stream().forEach(node -> {
            System.out.print(node.value + " ");
        });
    }

}
