import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Fei on 2/10/2018.
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, new NumbersComparator());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        String result = sb.toString();
        int index = 0;
        while (index < result.length() && result.charAt(index) == '0') {
            index++;
        }
        if (index == result.length()) {
            return "0";
        }
        return result.substring(index);
    }

    class NumbersComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return (s2 + s1).compareTo(s1 + s2);
        }
    }

    public static void main(String[] args) {
        LargestNumber number = new LargestNumber();
        int[] ds = {11,9,10,110};
        number.largestNumber(ds);
    }
}
