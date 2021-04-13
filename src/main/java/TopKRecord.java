import org.testng.annotations.Test;

import java.util.*;

public class TopKRecord {

    final int K = 3;
    Map<String, MyNode> countMap = new HashMap<>();
    PriorityQueue<MyNode> queue = new PriorityQueue<>((a, b) -> {
        return b.count - a.count;
    });

    public void add(String str) {
        MyNode node = countMap.get(str);
        if (node == null) {
            node = new MyNode(str, 0);
            countMap.put(str, node);
        }
        node.count++;
        queue.remove(node);
        queue.add(node);
    }

    //O(n)
    public List<String> getTopK() {
        List<String> res = new ArrayList<>();
        List<MyNode> nodes = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            MyNode node = queue.poll();
            res.add(node.str);
            nodes.add(node);
        }
        queue.addAll(nodes);
        return res;
    }

    private static class MyNode {
        String str;
        int count;

        public MyNode(String str, int count) {
            this.str = str;
            this.count = count;
        }
    }

    @Test
    public void test() {
        add("a");
        add("b");
        add("c");
        add("c");
        add("b");
        add("b");
        add("a");
        add("a");
        add("d");
        add("e");
        add("f");
        getTopK().stream().forEach(s -> {
            System.out.print(s + " ");
        });

    }

}
