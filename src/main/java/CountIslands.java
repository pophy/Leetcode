import org.testng.annotations.Test;

import java.util.ArrayList;

public class CountIslands {

    private int M;
    private int N;

    public int countIslands(int[][] m) {
        M = m.length;
        N = m[0].length;
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (m[i][j] == 1) {
                    count++;
                    dfs(m, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(int[][] m, int x, int y) {
        if (x < 0 || x >= M || y < 0 || y >= N || m[x][y] != 1) {
            return;
        }
        m[x][y] = 2;
        dfs(m, x + 1, y);
        dfs(m, x, y + 1);
        dfs(m, x - 1, y);
        dfs(m, x, y - 1);
    }

    public int countIslandUF(int[][] m) {
        int M = m.length;
        int N = m[0].length;
        UnionFind uf = new UnionFind();
        int counter = 1;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 1) {
                    counter++;
                    m[i][j] = counter;
                    uf.elementMap.put(counter, new Element<>(counter));
                }
            }
        }
        uf.init();

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] != 0) {
                    Element e = (Element) uf.elementMap.get(m[i][j]);

                    if (i - 1 > 0  && m[i - 1][j] != 0) {
                        Element e2 = (Element) uf.elementMap.get(m[i - 1][j]);
                        uf.union(e, e2);
                    }
                    if (i + 1 < M  && m[i + 1][j] != 0) {
                        Element e2 = (Element) uf.elementMap.get(m[i + 1][j]);
                        uf.union(e, e2);
                    }
                    if (j - 1 > 0  && m[i][j - 1] != 0) {
                        Element e2 = (Element) uf.elementMap.get(m[i][j - 1]);
                        uf.union(e, e2);
                    }
                    if (j + 1 < N && m[i][j + 1] != 0) {
                        Element e2 = (Element) uf.elementMap.get(m[i][j + 1]);
                        uf.union(e, e2);
                    }
                }
            }
        }

        return uf.count;
    }


    @Test
    public void test() {
        int[][] m = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 1}};

        System.out.println(countIslands(m));
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.print("\t\n");
        }
    }

    @Test
    public void test2() {
        int[][] m = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 1}};
        System.out.println(countIslandUF(m));

    }
}

