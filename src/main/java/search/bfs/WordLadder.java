package search.bfs;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //1 build graph
        Map<String, List<String>> graph = buildGraph(wordList,beginWord,endWord);
        //2 bfs
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) {
                    return steps;
                }
                List<String> nextWords = graph.get(currentWord);
                if (nextWords != null) {
                    for (String nextWord : nextWords) {
                        if (!visited.contains(nextWord)) {
                            queue.add(nextWord);
                        }
                        visited.add(nextWord);
                    }
                }
            }
        }
        return 0;
    }


    private Map<String, List<String>> buildGraph(List<String> dict, String start, String end) {
        List<String> copy = new ArrayList<>(dict);
        copy.add(start);
        copy.add(end);
        Map<String, List<String>> graph = new HashMap<>();
        for (int i = 0; i < copy.size(); i++) {
            for (int j = 0; j < copy.size(); j++) {
                if (isConnect(copy.get(i), copy.get(j))) {
                    if (!graph.containsKey(copy.get(i))) {
                        List<String> list = new ArrayList<>();
                        graph.put(copy.get(i), list);
                    }
                    graph.get(copy.get(i)).add(copy.get(j));
                }
            }
        }
        return graph;
    }

    private boolean isConnect(String word1, String word2) {
        int count = 0;
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            if (word1.charAt(i++) != word2.charAt(j++)) {
                count++;
            }
        }
        while (i < word1.length()) {
            i++;
            count++;
        }
        while (j < word2.length()) {
            j++;
            count++;
        }
        if (count == 1) {
            return true;
        }
        return false;
    }




    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int count = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            ++count;
            for (int i = 0; i < size; ++i) {
                String start = queue.poll();
                for (String s : wordList) {
                    // 已经遍历的不再重复遍历
                    if (visited.contains(s)) {
                        continue;
                    }
                    // 不能转换的直接跳过
                    if (!canConvert(start, s)) {
                        continue;
                    }
                    // 用于调试
                    // System.out.println(count + ": " + start + "->" + s);
                    // 可以转换，并且能转换成 endWord，则返回 count
                    if (s.equals(endWord)) {
                        return count + 1;
                    }
                    // 保存访问过的单词，同时把单词放进队列，用于下一层的访问
                    visited.add(s);
                    queue.offer(s);
                }
            }
        }
        return 0;
    }

    public boolean canConvert(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int count = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++count;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }












    @Test
    public void test() {
        String[] dict = {"hot","dot","dog","lot","log"};
        String start = "hit";
        String end = "cog";
        System.out.println(ladderLength(start, end, Arrays.asList(dict)));
    }

}
