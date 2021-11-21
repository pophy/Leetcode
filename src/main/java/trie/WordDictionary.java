package trie;

public class WordDictionary {


    TrieNode root = new TrieNode();

    public WordDictionary() {
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return helper(word, 0, root);
    }


    private boolean helper(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);

        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    if (helper(word, index + 1, node.children[i])) {
                        return true;
                    }
                }
            }
        } else {
            if (node.children[c - 'a'] != null && helper(word, index + 1, node.children[c - 'a'])) {
                return true;
            }
        }
        return false;
    }


    private static class TrieNode {
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
    }
}
