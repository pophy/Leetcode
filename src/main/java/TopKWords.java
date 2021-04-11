import org.testng.annotations.Test;

import java.util.*;


public class TopKWords {

    public List<String> topKFrequentWords(String[] words, int k) {
        List<String> res = new ArrayList<>(k);
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            if (countMap.containsKey(word)) {
                countMap.put(word, countMap.get(word) + 1);
            } else {
                countMap.put(word, 1);
            }
        }
        //最小堆大小为K
        PriorityQueue<MyNode> queue = new PriorityQueue<>((n1, n2) -> {
            return n1.count - n2.count;
        });
        for (String word : countMap.keySet()) {
            MyNode node = new MyNode(word, countMap.get(word));
            while (!queue.isEmpty() && queue.peek().count < node.count) {
                queue.poll();
            }
            queue.offer(node);
        }
        while (!queue.isEmpty()) {
            res.add(queue.poll().word);
        }
        return res;
    }

    public static class MyNode {
        String word;
        int count;

        public MyNode(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    @Test
    public void test() {
        String[] words = {"a","b","c","d","e","a","a","b","b","e","e"};
        topKFrequentWords(words,3).stream().forEach(w->{
            System.out.print(w + " ");
        });
    }


}
