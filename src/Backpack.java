/**
 * Created by Fei on 2/5/2018.
 */
public class Backpack {

    public int backPack(int m, int[] A) {
        int f[] = new int[m + 1];

        for (int i = 0; i < A.length; i++) {
            for (int j = m; j >= A[i]; j--) {
                f[j] = Math.max(f[j], f[j - A[i]] + A[i]);
            }
        }
        return f[m];
    }

    public static void main(String[] args) {
        Backpack backpack = new Backpack();
        int[] ds = {3,4,8,5};
        backpack.backPack(10,ds);
    }
}
