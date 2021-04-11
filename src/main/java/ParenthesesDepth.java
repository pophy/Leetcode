import org.testng.annotations.Test;

public class ParenthesesDepth {

    public int getDepth(String str) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            max = Math.max(max,count);
        }

        if (count != 0) {
            return -1;
        }
        return max;
    }

    @Test
    public void test() {
        String str = "()()()(())";
        System.out.println(getDepth(str));
    }
}
