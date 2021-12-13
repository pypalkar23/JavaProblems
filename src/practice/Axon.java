package practice;
import java.util.LinkedList;
import java.util.Queue;

class Axon {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    };

    static class queueNode {
        Point pt;
        int dist;

        public queueNode(Point pt, int dist) {
            this.pt = pt;
            this.dist = dist;
        }
    };

    static boolean isValid(int row, int col, int ROW, int COL) {
        return (row >= 0) && (row < ROW) &&
                (col >= 0) && (col < COL);
    }

    static int rowNum[] = { -1, 0, 0, 1 };
    static int colNum[] = { 0, -1, 1, 0 };

    static int BFS(int mat[][], Point src,
            Point dest, int ROW, int COL) {
        if (mat[src.x][src.y] != 1 ||
                mat[dest.x][dest.y] != 1)
            return -1;

        boolean[][] visited = new boolean[ROW][COL];

        visited[src.x][src.y] = true;

        Queue<queueNode> q = new LinkedList<>();

        queueNode s = new queueNode(src, 0);
        q.add(s);

        while (!q.isEmpty()) {
            queueNode curr = q.peek();
            Point pt = curr.pt;

            if (pt.x == dest.x && pt.y == dest.y)
                return curr.dist;
            q.remove();

            for (int i = 0; i < 4; i++) {
                int row = pt.x + rowNum[i];
                int col = pt.y + colNum[i];

                if (isValid(row, col, ROW, COL) &&
                        mat[row][col] == 1 &&
                        !visited[row][col]) {
                    visited[row][col] = true;
                    queueNode Adjcell = new queueNode(new Point(row, col),
                            curr.dist + 1);
                    q.add(Adjcell);
                }
            }
        }

        return -1;
    }

    public static long solution(String cityMap) {

        int startX = 0;
        int startY = 0;
        int goalX = 0;
        int goalY = 0;

        String[] grid1 = cityMap.split(";");

        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[i].length(); j++) {

                if (grid1[i].charAt(j) == '_') {
                    grid1[i] = grid1[i].replace('_', '1');
                }

                if (grid1[i].charAt(j) == 'X') {
                    grid1[i] = grid1[i].replace('X', '0');
                }

                if (grid1[i].charAt(j) == 'O') {
                    startX = i;
                    startY = j;
                    grid1[i] = grid1[i].replace('O', '1');
                }
                if (grid1[i].charAt(j) == 'T') {
                    goalX = i;
                    goalY = j;
                    grid1[i] = grid1[i].replace('T', '1');
                }
            }
        }

        Point source = new Point(startX, startY);
        Point dest = new Point(goalX, goalY);

        int mat[][] = new int[grid1.length][grid1[0].length()];

        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[i].length(); j++) {
                mat[i][j] = Character.getNumericValue(grid1[i].charAt(j));
            }
        }
        int dist = BFS(mat, source, dest, mat.length, mat[0].length);

        if (dist != Integer.MAX_VALUE)
            return dist;
        else
            return -1;

    }

public static void main(String[] args)
{
String s="O__;_XT;___";
String s1="OX;X_T;";
String s2="X;OXT;X";
String s3="";

System.out.println(solution(s));
//System.out.println(solution(s1));
System.out.println(solution(s2));
System.out.println(solution(s3));
}
}