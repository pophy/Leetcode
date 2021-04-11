import org.testng.annotations.Test;

import java.util.*;

public class SubsetEqualToK {

    //给定一个数组arr，求差值为k的去重数字对
    public List<int[]> solution(Integer[] m, int K) {

        List<int[]> resList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m.length; i++) {
            map.put(m[i], i);
        }

        for (int i = 0; i < m.length; i++) {
            if (map.containsKey(K + m[i])) {
                int[] res = new int[2];
                res[0] = map.get(K + m[i]);
                res[1] = i;
                resList.add(res);
            }
        }
        return resList;
    }

    @Test
    public void test() {
        Integer[] m = {2, 5, 4, 7, 1, 9};
        List<int[]> res = solution(m, 3);
        res.stream().forEach(r -> {
            System.out.println(r[0] + " " + r[1]);
        });
    }

}
