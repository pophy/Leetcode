
public class ReverseString {

    public static char[] reverseString(char[] source, int left, int right) {
        char tmp;
        while (left < right) {
            tmp = source[left];
            source[left] = source[right];
            source[right] = tmp;
            left ++;
            right --;
        }
        return source;
    }


    public static void main(String[] args) {
        char[] source = {'a','p','p','l','e'};
        System.out.print(reverseString(source,0,source.length-1));
    }

}
