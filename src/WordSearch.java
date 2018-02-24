/**
 * Created by Fei on 2/6/2018.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || board.length == 0 ) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                return exists(board,i,j,word,0);
            }
        }
        return false;

    }

    private boolean exists(char[][] board, int i, int j, String word, int index) {
        if (index >= word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (board[i][j] == word.charAt(index)) {
            char c = board[i][j];
            board[i][j] = '#';
            boolean res = exists(board,i - 1, j,word,index + 1) ||
                    exists(board,i + 1, j,word,index + 1) ||
                    exists(board,i, j + 1,word,index + 1) ||
                    exists(board,i, j - 1,word,index + 1);
            board[i][j] = c;
            return res;
        }
        return false;
    }

    public static void main(String[] args) {
        WordSearch search = new WordSearch();
        char[][] ds = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        search.exist(ds,"SEE");
    }
}
