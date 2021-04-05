
public class StringMatch {


    public static int stringMatch(String source, String target) {
        int result = -1;
        int m = source.toCharArray().length;
        int n = target.toCharArray().length;

        if (source == null || target == null) {
            return result;
        }

        if ( n > m) {
            return result;
        }

        int i,j;
        for (i=0;i<m-n;i++) {
            for (j=0;j<n;j++) {
                if (source.charAt(i+j) != target.charAt(j)) {
                    break;
                }
            }
            if (j == target.length()) {
                return i;
            }
        }
        return result;
    }

    public static void main (String[] args) {
        System.out.println(stringMatch("aababcd","abc"));
    }


}
