/**
 * Created by Fei on 2/16/2018.
 */
public class SelectionSort {

    public void sortIntegers(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        for (int i = 1; i < A.length; i++) {
            int temp = A[i];
            int j = i - 1;
            for (; j >= 0 && temp < A[j]; j--) {
                A[j + 1] = A[j];
            }
            A[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        int[] ds = {3,6,1,2};
        sort.sortIntegers(ds);
    }
}
