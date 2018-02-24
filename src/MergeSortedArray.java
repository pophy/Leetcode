
public class MergeSortedArray {

    public void mergeSortedArray(int[] s, int m, int[] t, int n) {
        if (s == null || t == null || s.length == 0 || t.length == 0) {
            return;
        }
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (s[i] > t[j]) {
                s[k] = s[i];
                k--;
                i--;
            } else {
                s[k] = t[j];
                k--;
                j--;
            }
        }
        while (i >= 0) {
            s[k] = s[i];
            i--;
            k--;
        }
        while (j >= 0) {
            s[k] = t[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args) {
        int[] dataA = new int[9];
        dataA[0] = 9;
        dataA[1] = 10;
        dataA[2] = 11;
        dataA[3] = 12;
        dataA[4] = 13;
        int[] dataB = {4,5,6,7};


        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.mergeSortedArray(dataA,5,dataB,4);


    }
}
