import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class ConvexHullNaive {
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

    public void convexHull(Point points[]) {
        int n = points.length;

        if (n < 3)
            return;

        List<Point> hull = new ArrayList<Point>(1);

        int l = 0;
        //look for leftmost point
        for (int i = 1; i < n; i++) {
            if (points[i].x < points[l].x)
                l = i;
        }

        int p = l, q;
        do {
            hull.add(0, points[p]);
            /* 
            Search for a point 'q' such that orientation(p, x,
            q) is counterclockwise for all points 'x'. The idea
            is to keep track of last visited most counterclock-
            wise point in q. If any point 'i' is more counterclock-
            wise than q, then update q.
            */
            q = (p + 1) % n;
            for (int i = 0; i < n; i++) {
                if (orientation(points[p], points[i], points[q]) == 2)
                    q = i;
            }
            p = q;
        } while (p != l);

        for (Point point : hull)
            System.out.println("(" + point.x + " " + point.y + ")");
    }

    public static void main(String[] args) {
        Point points[] = new Point[7];
        points[0] = new Point(0, 3);
        points[1] = new Point(2, 2);
        points[2] = new Point(1, 1);
        points[3] = new Point(2, 1);
        points[4] = new Point(3, 0);
        points[5] = new Point(0, 0);
        points[6] = new Point(3, 3);
        ConvexHullNaive convexNaive = new ConvexHullNaive();
        convexNaive.convexHull(points);
    }
}