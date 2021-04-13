import org.testng.annotations.Test;

import java.util.TreeMap;

public class PrintDirectory {

    public void print(String[] m) {
        for (int i = 0; i < m.length; i++) {
            String[] arr = m[i].split("\\\\");
            for (int j = 0; j < arr.length; j++) {
                Trie.add(arr);
            }
        }
        printTrie(Trie.root, 0);
    }

    private void printTrie(TrieNode root, int level) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.print(root.name + "\t\n");
        for (TrieNode node : root.map.values()) {
            printTrie(node, level + 1);
        }
    }

    private static class Trie {
        private static TrieNode root = new TrieNode("");

        public static void add(String[] str) {
            TrieNode cur = root;
            for (int i = 0; i < str.length; i++) {
                if (!cur.map.containsKey(str[i])) {
                    TrieNode node = new TrieNode(str[i]);
                    cur.map.put(str[i], node);
                }
                cur = cur.map.get(str[i]);
            }
        }
    }

    private static class TrieNode {
        String name;
        TreeMap<String, TrieNode> map = new TreeMap<>();

        public TrieNode(String name) {
            this.name = name;
        }
    }

    @Test
    public void test() {
        String[] m = {"b\\cst", "d\\", "a\\d\\e", "a\\b\\c"};
        print(m);
    }

}
