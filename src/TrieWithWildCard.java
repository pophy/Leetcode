import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fei on 2/16/2018.
 */
public class TrieWithWildCard {
    TrieNode root = new TrieNode();

    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    /*
     * @param word: A word could contain the dot character '.' to represent any one letter.
     * @return: if the word is in the data structure.
     */
    public boolean find(String word, int index, TrieNode root) {
        if (index == word.length()) {
            return root.children.isEmpty();
        }
        Character c = word.charAt(index);
        if (root.children.containsKey(c)) {
            if (index == word.length() - 1) {
                return root.children.get(c).isWord;
            }
            return find(word, index + 1, root.children.get(c));
        } else if (c == '.') {
            for (Character cc : root.children.keySet()) {
                if (index == word.length() -1) {
                    return root.children.get(cc).isWord;
                }
                return find(word, index + 1, root.children.get(cc));
            }
        } else {
            return false;
        }
        return false;
    }

    public boolean search(String word) {
        // Write your code here
        return find(word, 0, root);
    }

    public static void main(String[] args) {
        TrieWithWildCard trieWithWildCard = new TrieWithWildCard();
        trieWithWildCard.addWord("ran")                            ;
        trieWithWildCard.addWord("rune")                            ;
        trieWithWildCard.addWord("runner")                           ;
        trieWithWildCard.addWord("runs")                              ;
        trieWithWildCard.addWord("add")                                ;
        trieWithWildCard.addWord("adds")                                ;
        trieWithWildCard.addWord("adder")                                ;
        trieWithWildCard.addWord("addee")                                 ;
        System.out.println(trieWithWildCard.search(".......")     );                            ;
        System.out.println(trieWithWildCard.search("..n.r")                          );          ;
    }

}

class TrieNode {
    Map<Character,TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isWord;
}