import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fei on 2/1/2018.
 */
public class MinWinSubString {

    public String minWindow(String source, String target) {
        Map<Character, Integer> dict = new HashMap();
        for (Character c:source.toCharArray()) {
            dict.put(c,0);
        }
        for (Character c:target.toCharArray()) {
            if (dict.containsKey(c)) {
                dict.put(c,dict.get(c) + 1);
            } else {
                return "";
            }
        }
        int start = 0; int end = 0; int head = 0; int minLength = Integer.MAX_VALUE; int counter = target.length();
        while (end < source.length()) {
            Character c = source.charAt(end);
            if (dict.get(c) > 0) {
                counter--;
            }
            dict.put(c,dict.get(c) - 1);
            end++;

            while(counter == 0) {
                if (minLength > end - start) {
                    head = start;
                    minLength = end - start;
                }
                Character c2 = source.charAt(start);
                dict.put(c2,dict.get(c2) + 1);
                if (dict.get(c2) > 0) {
                    counter++;
                }
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE? "" : source.substring(head,head + minLength);

    }



    public static void main(String[] args) {
        MinWinSubString subString = new MinWinSubString();
        subString.minWindow("AADOBECODEBANCBA","AABC");
    }
}
