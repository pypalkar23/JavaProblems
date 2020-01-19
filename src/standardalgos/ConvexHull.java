
package standardalgos;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class ConvexHull {
    Point p0;

    public int orientation(Point p, Point q, Point r) {
        /**
         Orientation formula for points with coordinates (x1,y1),(x2,y2),(x3,y3)
         val=(y2-y1)*(x3-x2)-
             (x2-x1)*(y3-y2)
         if val==0 colinear
         if val >0 clockwise else anticlockwise
         */
        int orientVal = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

        return (orientVal == 0) ? 0 : (orientVal > 0) ? 1 : 2;
    }

    class ComparePoints implements Comparator<Point> {

        public int compare(Point p, Point q) {
            int orientVal = orientation(p0, p, q);
            if (orientVal == 0)
                return (distSq(p0, q) >= distSq(p0, p)) ? -1 : 1;

            return (orientVal == 2) ? -1 : 1;
        }
    }

    public static double distSq(Point p, Point q) {
        return Math.sqrt((p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y));
    }

    public Point nextToTop(Stack<Point> s) {
        Point top = s.pop();
        Point nextToTop = s.peek();
        s.push(top);
        //System.out.println(s.size());
        return nextToTop;
    }

    public void convexHull(Point points[]) {
        int n = points.length;
        int ymin = points[0].y, min = 0;
        for (int i = 1; i < n; i++) {
            int y = points[i].y;

            if ((y < ymin) || (ymin == y && points[i].x < points[min].x)) {
                ymin = points[i].y;
                min = i;
            }

        }

        Point temp = points[0];
        points[0] = points[min];
        points[min] = temp;

        p0 = points[0];
        //sort all points expect 0th point
        Arrays.sort(points, 1, n, new ComparePoints());

        int m = 1;
        for (int i = 1; i < n; i++) {
            // Keep removing i while angle of i and i+1 is same
            // with respect to p0
            while (i < n - 1 && orientation(p0, points[i], points[i + 1]) == 0)
                i++;
            points[m] = points[i];
            m++;
        }

        if (m < 3)
            return;

        Stack<Point> s = new Stack<Point>();
        s.push(points[0]);
        s.push(points[1]);
        s.push(points[2]);

        for (int i = 3; i < m; i++) {
            //System.out.println(s.size());
            while (orientation(nextToTop(s), s.peek(), points[i]) != 2) {
                s.pop();
            }
            s.push(points[i]);

            //System.out.println(s.size());
        }

        while (!s.empty()) {
            Point p = s.pop();
            System.out.println(p.x + " " + p.y);
        }

    }

    public static void main(String[] args) {
        Point points[] = new Point[8];
        points[0] = new Point(0, 3);
        points[1] = new Point(1, 1);
        points[2] = new Point(2, 2);
        points[3] = new Point(4, 4);
        points[4] = new Point(0, 0);
        points[5] = new Point(1, 2);
        points[6] = new Point(3, 1);
        points[7] = new Point(3, 3);
        ConvexHull cHull = new ConvexHull();
        cHull.convexHull(points);
    }
}