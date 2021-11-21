package hashMapRelated;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class NumberOfBoomerangs {


    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int n = points.length;
        Map<int[], Map<Integer, Integer>> countMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (countMap.get(points[i]) == null) {
                    countMap.put(points[i], new HashMap<>());
                }
                Map<Integer, Integer> distMap = countMap.get(points[i]);
                int dist = getDistance(points[i], points[j]);
                distMap.put(dist, distMap.getOrDefault(dist, 0) + 1);
            }
        }
        int count = 0;
        for (int[] point : countMap.keySet()) {
            Map<Integer, Integer> distMap = countMap.get(point);
            for (int dist : distMap.keySet()) {
                count += distMap.get(dist) * (distMap.get(dist) - 1);
            }
        }
        return count;
    }

    private int getDistance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

}
