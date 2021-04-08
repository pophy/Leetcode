import org.testng.annotations.Test;

public class RGBoxPaint {

    /**
     *
     * @param str
     * @return
     *
     * RGRGB -> RRRGG
     * A = {0,1,1,2,2}
     * B = {2,1,1,1,0}
     *
     */


    public int leastPaint(String str) {
        int count = Integer.MAX_VALUE;
        char[] array = str.toCharArray();
        int N = array.length;
        //预处理数组 数左侧有多少个G需要转成R
        int[] A = new int[array.length];
        //预处理数组 数右侧有多少个R需要转成G
        int[] B = new int[array.length];
        A[0] = array[0] == 'G' ? 1 : 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == 'G') {
                A[i] = A[i - 1] + 1;
            } else {
                A[i] = A[i - 1];
            }
        }
        B[N - 1] = array[N - 1] == 'R' ? 1 : 0;
        for (int i = N - 2; i >= 0; i--) {
            if (array[i] == 'R') {
                B[i] = B[i + 1] + 1;
            } else {
                B[i] = B[i + 1];
            }
        }

        for (int l = 0; l <= array.length; l++) {
            if (l == 0) {
                count = Math.min(count, getCount(0, 'R', A, B));
            } else if (l == array.length) {
                count = Math.min(count, getCount(N - 1, 'G', A, B));
            } else {
                count = Math.min(count, getCount(l - 1, 'G', A, B) + getCount(l, 'R', A, B));
            }
        }
        return count;
    }

    private int getCount(char[] array, int l, int r, char g) {
        int count = 0;
        for (int i = l; i < r; i++) {
            if (array[i] != g) {
                count++;
            }
        }
        return count;
    }

    private int getCount(int l, char g, int[] A, int[] B) {
        if (g == 'G') {
            return A[l];
        } else {
            return B[l];
        }
    }

    @Test
    public void test() {
        System.out.println(leastPaint("RGRGG"));
    }

}
