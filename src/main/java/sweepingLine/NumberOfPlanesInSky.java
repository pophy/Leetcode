package sweepingLine;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberOfPlanesInSky {

    public int countPlanes(int[][] planes) {
        List<Pair<Integer,Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < planes.length; i++) {
            Pair up = new Pair(planes[i][0],1);
            Pair down = new Pair(planes[i][1],-1);
            pairs.add(up);
            pairs.add(down);
        }
        Collections.sort(pairs,(p1,p2) -> {
            if (p1.getKey() == p2.getKey()) {
                return p1.getValue() - p2.getValue();
            }
            return p1.getKey() - p2.getKey();
        });
        int res = 0;
        int cnt = 0;
        for (Pair p : pairs) {
            if ((int)p.getValue() == 1) {
                cnt++;
            } else {
                cnt--;
            }
            res = Math.max(cnt,res);
        }
        return res;
    }

    @Test
    public void test() {
        int[][] planes = {
                {1,10},
                {3,4},
                {2,3},
                {6,9},
                {2,7}
        };
        System.out.println(countPlanes(planes));
    }


}
