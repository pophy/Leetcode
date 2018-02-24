import java.util.*;

/**
 * Created by Fei on 2/13/2018.
 */
public class MinNumber {

    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        List<Integer> list  = new ArrayList<Integer>();
        for (Integer i : nums) {
            list.add(i);
        }
        Collections.sort(list,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                return (s1+s2).compareTo(s2+s1);
            }
        });

        StringBuffer sb = new StringBuffer();
        for (Integer i : nums) {
            sb.append(String.valueOf(i));
        }
        return sb.toString();
    }
}
