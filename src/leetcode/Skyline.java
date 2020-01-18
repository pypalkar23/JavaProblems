package leetcode;
class Skyline {
    /** https://leetcode.com/problems/max-increase-to-keep-city-skyline/ */

    public static void main(String[] args) {
        Skyline s = new Skyline();
        int grid[][] = new int[][] { { 3, 0, 8, 4 }, { 2, 4, 5, 7 }, { 9, 2, 6, 3 }, { 0, 3, 1, 0 } };
        System.out.println(s.maxIncreaseKeepingSkyline(grid));
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null)
            return 0;
        if (grid.length == 0)
            return 0;

        int rows = grid.length;
        int columns = grid[0].length;

        int[] topBottom = new int[columns]; // by j
        int[] leftRight = new int[rows]; // by i

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] > topBottom[j])
                    topBottom[j] = grid[i][j];
                if (grid[i][j] > leftRight[i])
                    leftRight[i] = grid[i][j];
            }
        }

        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int maxIncr = Math.min(topBottom[j], leftRight[i]);
                result += (maxIncr > grid[i][j]) ? maxIncr - grid[i][j] : 0;
                //grid[i][j] = (maxIncr > grid[i][j]) ? grid[i][j] + (maxIncr - grid[i][j]) : grid[i][j];
            }
        }

        /*for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println(" ");
        }*/

        /*
         * print(topBottom); print(leftRight);
         */
        return result;
    }

    public void print(int a[]) {
        for (int i : a)
            System.out.print(i + " ");
        System.out.println(" ");
    }
}