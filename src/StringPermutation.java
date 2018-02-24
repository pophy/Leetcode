import java.util.Arrays;

/**
 * Created by Fei on 1/14/2018.
 */
public class StringPermutation {
    public boolean Permutation(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        boolean flag = true;
        for (int i=0;i<a.length;i++) {
            if (a[i] != b[i]) {
                flag = false;
                break;
            }
        }
        return flag;

    }

    public static void main(String[] args) {
        StringPermutation stringPermutation = new StringPermutation();
        stringPermutation.Permutation("abcd","dcba");
    }
}
