import org.testng.annotations.Test;

public class StringToNumber {

    final int LIMIT = Integer.MAX_VALUE / 10;
    final int ADD_LIMIT = Integer.MAX_VALUE % 10;
    /**
     * 给定一个字符串，如果该字符串符合人们日常书写一个整数的形式，返回int类型的这个数；如果不符合或者越界返回-1或者报错。
     * 01 false
     * +1 false
     * +-12 false
     * 123ab false
     * -123 true
     * 1234 true
     */

    public int convert(String str) {
        if (!isValid(str)) {
            return -1;
        }
        int isNegtive = 1;
        if (str.charAt(0) == '-') {
            isNegtive = -1;
        }
        int res = 0;
        for (int i = isNegtive == -1 ? 1 : 0; i < str.length(); i++) {
            if (res > LIMIT) {
                return -1;
            }
            res = res * 10 + (str.charAt(i) - '0');
        }
        return res*isNegtive;
    }

    private boolean isValid(String str) {
        if (str.matches("[^0]\\d+") || str.matches("-[^0]\\d+") || str.equals("0")) {
            return true;
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(convert("-2147483648"));
    }

}
