import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxPoints {

    public int maxPoints(Point[] points) {
        if (points == null ) {
            return 0;
        }
        if (points.length <= 1) {
            return points.length;
        }
        int max = 0;

        Map<Double, Set<Point>> map = new HashMap();
        Set<Point> specialPoint = new HashSet<Point>();
        map.put(-1.0,specialPoint);
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Point a = points[i];
                Point b = points[j];
                if (a.x == b.x) {

                    specialPoint.add(a);
                    specialPoint.add(b);

                    continue;
                }
                Double rate = (double)(b.y - a.y) / (double)(b.x - a.x);
                if (!map.containsKey(rate)) {
                    Set<Point> set = new HashSet<Point>();
                    map.put(rate,set);
                }
                map.get(rate).add(a);
                map.get(rate).add(b);
            }
        }
        for (Double rate : map.keySet()) {
            int count = map.get(rate).size();
            max = Math.max(count,max);
        }

        return max ;
    }

    public static void main(String[] args) {
        MaxPoints maxPoints = new MaxPoints();
        Point[] ds = new Point[3];
        Point point1 = new Point(0,0,1);
        Point point2 = new Point(1,1,2);
        Point point3 = new Point(1,-1,3);
        Point point4 = new Point(1,3,4);
        ds[0] = point1;
        ds[1] = point2;
        ds[2] = point3;
//        ds[3] = point4;
        maxPoints.maxPoints(ds);
    }

}

 class Point {
         int label;
         int x;
         int y;
         Point() { x = 0; y = 0; }
         Point(int a, int b, int label) { x = a; y = b; this.label = label;}
     }