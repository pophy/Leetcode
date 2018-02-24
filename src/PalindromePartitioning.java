import java.util.*;


public class PalindromePartitioning {


    List<List<String>> result = new ArrayList();

    public List<List<String>> partition(String s) {
        result.clear();
        backtracking(s,new ArrayList(),0);
        return result;
    }

    private void backtracking(String s, List<String> path, int index) {
        if (index == s.length()) {
            result.add(new ArrayList(path));
        }

        for (int i = index; i < s.length(); i++) {
            if(isPalindrome(s, index, i)){
                path.add(s.substring(index, i + 1));
                backtracking(s, path, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int low, int high){
        while(low < high)
            if(s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning partitioning = new PalindromePartitioning();
        partitioning.partition("a");
    }
}
