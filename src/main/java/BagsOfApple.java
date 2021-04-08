import org.testng.annotations.Test;

public class BagsOfApple {

    public int leastBags(int N, int smallBag, int bigBag) {
        int count = N / bigBag;
        for (int i = count; i >= 0; i--) {
            int reminds = N - i * bigBag;
            if (reminds % smallBag == 0) {
                return i + reminds / smallBag;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        System.out.println(leastBags(30,3,7));
    }
}
