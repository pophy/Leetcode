import java.util.*;

/**
 * Created by fei on 2/10/18.
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (n < 0) {
            return false;
        }
        Map<Integer,List<Integer>> graph = buildGraph(n,edges);
        //bfs
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet();
        queue.offer(0);
        visited.add(0);
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            List<Integer> neighbors = graph.get(current);
            for (Integer nn : neighbors) {
                if (visited.contains(nn)) {
                    continue;
                }
                visited.add(nn);
                queue.offer(nn);
            }
        }
        return visited.size() == n;

    }

    private Map<Integer,List<Integer>> buildGraph(int n, int[][] edges) {
        Map<Integer,List<Integer>> graph = new HashMap();
        for (int i = 0; i < n; i++) {  //add nodes
            List<Integer> neighbors = new ArrayList();
            graph.put(i,neighbors);
        }
        //add edges, undirected edges will be saved twice a -> b && b -> a
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }

    public static void main(String[] args) {
        GraphValidTree tree = new GraphValidTree();
        int[][] ds = {{0,1},{0,2},{0,3},{1,4}};
        tree.validTree(5,ds);
    }
}
