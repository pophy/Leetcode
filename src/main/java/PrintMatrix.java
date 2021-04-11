import org.testng.annotations.Test;

public class PrintMatrix {
    /**
     * 用zigzag的方式打印矩阵，
     * 比如如下的矩阵
     * 0 1 2 3
     * 4 5 6 7
     * 8 9 10 11
     * 打印顺序为：0 1 4 8 5 2 3 6 9 10 7 11
     */

    public void print1(int[][] m) {
        int N = m.length;
        int M = m[0].length;
        int ax = 0, ay = 0, bx = 0, by = 0;
        boolean flag = true;
        System.out.print(m[0][0] + " ");
        for (int i = 0; i < M + N; i++) {
            if (ay == M - 1) {
                ax++;
            } else {
                ay++;
            }
            if (bx == N - 1) {
                by++;
            } else {
                bx++;
            }
            printLn(m, ax, ay, bx, by, flag);
            flag = !flag;
        }
    }

    public void printLn(int[][] m, int ax, int ay, int bx, int by, boolean isDown) {
        int M = m.length;
        int N = m[0].length;

        while (ax >= 0 && ax < M && ay >= 0 && ay < N && bx >= 0 && bx < M && by >= 0 && by < N) {
            if (isDown) {
                System.out.print(m[ax][ay] + " ");
                ax++;
                ay--;
            } else {
                System.out.print(m[bx][by] + " ");
                bx--;
                by++;
            }
        }

    }


    /**
     * 用螺旋的方式打印矩阵，比如如下的矩阵
     */

    public void print2(int[][] m) {
        int N = m.length;
        int M = m[0].length;
        int ax = 0, ay = 0, bx = N - 1, by = M - 1;
        while (ax <= bx && ay <= by) {
            printBorder(m, ax++, ay++, bx--, by--);
        }

    }

    public void printBorder(int[][] m, int ax, int ay, int bx, int by) {
        if (ax == bx) {
            for (int i = ay; i <= by; i++) {
                System.out.print(m[ax][i] + " ");
            }
        } else if (ay == by) {
            for (int i = ax; i <= bx; i++) {
                System.out.print(m[i][by] + " ");
            }
        } else {
            int curX = ax;
            int curY = ay;
            while (curY != by) {
                System.out.print(m[ax][curY] + " ");
                curY++;
            }
            while (curX != bx) {
                System.out.print(m[curX][by] + " ");
                curX++;
            }
            while (curY != ay) {
                System.out.print(m[bx][curY] + " ");
                curY--;
            }
            while (curX != ax) {
                System.out.print(m[curX][ay] + " ");
                curX--;
            }
        }
    }


    @Test
    public void test() {
        int[][] m = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        print2(m);
//        printBorder(m,1,1,1,2);
    }

}
