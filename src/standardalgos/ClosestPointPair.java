package standardalgos;
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */

class compareX implements Comparator<Point> {
    public int compare(Point p1, Point p2) {
        return p1.x - p2.x;
    }
}

class compareY implements Comparator<Point> {
    public int compare(Point p1, Point p2) {
        return p1.y - p2.y;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

class ClosestPair {
    public double dist(Point p, Point q) {
        return Math.sqrt((p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y));
    }

    public double bruteforce(Point[] points) {
        double minDist = Double.MAX_VALUE;
        for (int i = 0, n = points.length; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                double tempDist = dist(points[i], points[j]);
                if (tempDist < minDist)
                    minDist = tempDist;
            }
        return minDist;
    }

    public double stripClosest(Point[] strip, double d) {
        double min = d;
        Arrays.sort(strip, (p1, p2) -> p1.y - p2.y);
        int n = strip.length;

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n && Math.abs(strip[i].y - strip[j].y) < min; j++) {
                double tempDist = dist(strip[i], strip[j]);
                if (tempDist < min)
                    min = tempDist;
            }
        return min;
    }

    public double closest(Point points[]) {
        //first sort by x
        Arrays.sort(points, (p1, p2) -> p1.x - p2.x);
        return closestUtil(points);
    }

    public double closestUtil(Point points[]) {
        int lengthOfArray = points.length;
        if (lengthOfArray <= 3)
            return bruteforce(points);

        int mid = lengthOfArray / 2;

        Point midpoint = points[mid];

        double dl = closestUtil(Arrays.copyOfRange(points, 0, mid));
        double dr = closestUtil(Arrays.copyOfRange(points, mid + 1, lengthOfArray));

        double d = Math.min(dl, dr);

        Point strip[] = new Point[lengthOfArray];
        int j = 0;
        for (int i = 0; i < lengthOfArray; i++) {
            if (Math.abs(points[i].x - midpoint.x) < d) {
                strip[j++] = points[i];
            }
        }

        return Math.min(d, stripClosest(points, d));
    }
}

class ClosestPointPair {
    public static void main(String[] args) throws java.lang.Exception {
        ClosestPair cp = new ClosestPair();
        Point[] points = new Point[6];
        points[0] = new Point(2, 3);
        points[1] = new Point(12, 30);
        points[2] = new Point(40, 50);
        points[3] = new Point(5, 1);
        points[4] = new Point(12, 10);
        points[5] = new Point(3, 4);
        System.out.println(cp.closest(points));
    }
}