package sweepingLine;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeetingRoom {

    /**
     * giving an array of meeting time intervals consisting of start and end times, find the mininum number of conference room required
     */

    public int minMeetingRooms(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(new int[]{intervals[i][0], 1});
            list.add(new int[]{intervals[i][1], -1});
        }
        Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int res = 0;
        int cur = 0;
        for (int[] point : list) {
            cur = cur + point[1];
            res = Math.max(res, cur);
        }
        return res;
    }

    @Test
    public void test() {
        int[][] intervals = {
                {0,30},
                {5,10},
                {15,20}
        };
        System.out.println(minMeetingRooms(intervals));
    }

}
