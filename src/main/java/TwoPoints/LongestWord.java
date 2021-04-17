package TwoPoints;

import org.junit.jupiter.api.Test;

/**
 * 删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，找出能构成的最长字符串。
 * 如果有多个相同长度的结果，返回字典序的最小字符串。
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * <p>
 * Output:
 * "apple"
 */

public class LongestWord {

    public String solution(String target, String[] dict) {
        String res = "";

        for (String word : dict) {
            if (dict.length > target.length()) {
                return null;
            }
            if (isSubString(target, word)) {
                res = res.length() < word.length() ? word : res;
            }
        }

        return res;
    }

    //abpcplea plea
    private boolean isSubString(String source, String word) {
        int i = 0;
        int j = 0;
        while (i < source.length() && j < word.length()) {
            if (source.charAt(i) == word.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == word.length();
    }

    @Test
    public void test() {
        String[] dict = {"ale","apple","monkey","plea"};
        System.out.println(solution("abpcplea",dict));
    }

}
