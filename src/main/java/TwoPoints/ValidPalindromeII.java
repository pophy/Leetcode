package TwoPoints;

import org.junit.jupiter.api.Test;

/**
 * 题目描述：可以删除一个字符，判断是否能构成回文字符串。
 */
public class ValidPalindromeII {

    public boolean solution(String str) {
        if (str.length() == 0) {
            return true;
        }
        int l = 0;
        int r = str.length() - 1;
        char[] arr = str.toCharArray();
        while (l <= r) {
            if (arr[l] != arr[r]) {
                return isPalindrome(arr, l + 1, r) || isPalindrome(arr, l, r-1);
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isPalindrome(char[] arr, int l, int r) {
        while (l <= r) {
            if (arr[l] != arr[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    @Test
    public void test() {
        String str = "abccbaf";
        System.out.println(solution(str));
    }

}
