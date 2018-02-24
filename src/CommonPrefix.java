/**
 * Created by Fei on 2/4/2018.
 */
public class CommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String minWord = strs[0];
        for (String word : strs) {
            if (word.length() < minWord.length()) {
                minWord = word;
            }
        }

        int end=minWord.length();
        for(int i=0;i<strs.length;i++){
            int j;
            for( j=0;j<end;j++){
                if(minWord.charAt(j)!=strs[i].charAt(j))
                    break;
            }
            if(j<end)
                end=j;
        }

        return minWord.substring(0,end);
    }

    public static void main(String[] args) {
        CommonPrefix commonPrefix = new CommonPrefix();
        String[] ds = {"ABCD","ABEF","ACEF"};
        commonPrefix.longestCommonPrefix(ds);

    }
}
