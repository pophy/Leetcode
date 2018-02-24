/**
 * Created by fei on 2/2/18.
 */
public class SortLetterByCase {

    public void sortLetters(char[] chars) {
        if (chars == null || chars.length == 0) {
            return;
        }
        int start = 0; int end = chars.length - 1;
        while (start <= end) {
            if (Character.isLowerCase(chars[end]) && Character.isUpperCase(chars[start])) {
                swap(chars,start++,end--);
            }
            if (Character.isUpperCase(chars[end])) {
                end--;
            }
            if (Character.isLowerCase(chars[start])) {
                start++;
            }
        }

    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        SortLetterByCase sortLetterByCase = new SortLetterByCase();
        char[] ds = {'a','b','A','c','D'};
        sortLetterByCase.sortLetters(ds);
        System.out.println();
    }
}
