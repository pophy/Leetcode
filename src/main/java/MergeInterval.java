import java.util.ArrayList;
import java.util.List;

public class MergeInterval {



    private void helper(List<Interval> intervals, int start, int end) {
        if (start < end) {

        }

    }

    private List<Interval> merge(List<Interval> leftVal, List<Interval> rightVal) {
        List<Interval> mergedList = new ArrayList();
        for (Interval left : leftVal) {
            for (Interval right : rightVal) {
                if (left.start >= right.start && left.end <= right.end) {
                    mergedList.add(right);
                } else if (left.start <= right.start && left.end >= right.end) {
                    mergedList.add(left);
                } else if (left.start >= right.start && left.end >= right.end) {
                    Interval newInterval = new Interval(right.start,left.end);
                    mergedList.add(newInterval);
                } else if (left.start <= right.start && left.end <= right.end) {
                    Interval newInterval = new Interval(left.start,right.end);
                    mergedList.add(newInterval);
                } else {
                    mergedList.add(left);
                    mergedList.add(right);
                }
            }
        }
        return mergedList;
    }

    public static void main(String[] args) {
        MergeInterval merge = new MergeInterval();
        List<Interval> list = new ArrayList<Interval>();
        Interval i = new Interval(1,4);
        Interval i1 = new Interval(1,4);
        list.add(i);
        list.add(i1);
       // merge.merge(list);
    }
}

class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}