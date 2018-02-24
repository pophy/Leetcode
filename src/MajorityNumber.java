import java.util.*;

/**
 * Created by fei on 1/6/18.
 */
public class MajorityNumber {

    public int majorityNumber(List<Integer> nums, int k) {
        // count at most k keys.
        HashMap<Integer, Integer> counters = new HashMap<Integer, Integer>();
        for (Integer i : nums) {
            if (!counters.containsKey(i)) {
                counters.put(i, 1);
            } else {
                counters.put(i, counters.get(i) + 1);
            }

            if (counters.size() >= k) {
                removeKey(counters);
            }
        }

        // corner case
        if (counters.size() == 0) {
            return Integer.MIN_VALUE;
        }

        // recalculate counters
        for (Integer i : counters.keySet()) {
            counters.put(i, 0);
        }
        for (Integer i : nums) {
            if (counters.containsKey(i)) {
                counters.put(i, counters.get(i) + 1);
            }
        }

        // find the max key
        int maxCounter = 0, maxKey = 0;
        for (Integer i : counters.keySet()) {
            if (counters.get(i) > maxCounter) {
                maxCounter = counters.get(i);
                maxKey = i;
            }
        }

        return maxKey;
    }

    private void removeKey(HashMap<Integer, Integer> counters) {
        Set<Integer> keySet = counters.keySet();
        List<Integer> removeList = new ArrayList<>();
        for (Integer key : keySet) {
            counters.put(key, counters.get(key) - 1);
            if (counters.get(key) == 0) {
                removeList.add(key);
            }
        }
        for (Integer key : removeList) {
            counters.remove(key);
        }
    }


    public static void main(String[] args) {
        MajorityNumber majorityNumber = new MajorityNumber();
        int[] dataSource = {3,1,2,3,2,3,3,4,4,4};
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<dataSource.length;i++) {
            list.add(dataSource[i]);
        }
        majorityNumber.majorityNumber(list,3);
    }

}
