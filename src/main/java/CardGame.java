import org.testng.annotations.Test;

public class CardGame {

    public int maxScore(int[] m) {
        return Math.max(first(m, 0, m.length - 1), second(m, 0, m.length - 1));
    }

    private int first(int[] m, int l, int r) { //先手
        if (l == r) {
            return m[l];
        }
        return Math.max(second(m, l + 1, r) + m[l], second(m, l, r - 1) + m[r]);
    }

    private int second(int[] m, int l, int r) { //后手
        if (l == r) {
            return 0;
        }
        return Math.min(first(m, l + 1, r), first(m, l, r - 1));
    }

    @Test
    public void test() {
        int[] m = {1, 9, 1};
        System.out.println(maxScore(m));
    }

}
