package trie;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    List<String> res;
    boolean[][] visited;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        res = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, new StringBuilder(), trie);
            }
        }
        return res;
    }


    private void dfs(char[][] board, int x, int y, StringBuilder sb, Trie trie) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited[x][y]) {
            return;
        }
        sb.append(board[x][y]);
        if (!trie.startWith(sb.toString())) {
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        if (trie.search(sb.toString())) {
            res.add(sb.toString());
            trie.remove(sb.toString());
        }

        visited[x][y] = true;
        for (int[] d : directions) {
            int nx = x + d[0];
            int ny = y + d[1];
            dfs(board, nx, ny, sb, trie);

        }
        visited[x][y] = false;
        sb.deleteCharAt(sb.length() - 1);
    }

    private class Trie {

        TrieNode root = new TrieNode();

        public boolean search(String str) {
            TrieNode cur = root;
            for (char c : str.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
            return cur.isWord;
        }

        public boolean startWith(String str) {
            TrieNode cur = root;
            for (char c : str.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
            return true;
        }

        public void insert(String str) {
            TrieNode cur = root;
            for (char c : str.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }

        public void remove(String str) {
            TrieNode cur = root;
            for (char c : str.toCharArray()) {
                cur = cur.children[c - 'a'];
            }
            cur.isWord = false;
        }

    }

    private class TrieNode {
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
    }

    @Test
    public void test() {
        char[][] board = {{'a', 'b'}, {'d', 'c'}};
        String[] words = {"abc"};
        findWords(board, words);
    }

}
