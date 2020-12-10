package leetcode;

/*200. Number of Islands*/
public class NumberIslands {
    // vertical or horizontal connections are allowed
    int[][] directions = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

    public static void main(String[] args) {
        char grid[][] = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' } };

        System.out.println(new NumberIslands().numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int count = 0;
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !seen[i][j]) {
                    count++;
                    // setSeen(grid, seen, i, j);
                }
            }
        return count;
    }

    // using additional matrix
    public void setSeen(char[][] grid, boolean seen[][], int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || seen[i][j] || grid[i][j] == '0')
            return;

        // marking current cell as land
        seen[i][j] = true;
        // recursively checking adjecent cells for land
        for (int k = 0; k < directions.length; k++) {
            setSeen(grid, seen, i + directions[k][0], j + directions[k][1]);
        }
    }

    // using the grid itself
    public void setSeen(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;

        grid[i][j] = '0';
        for (int k = 0; k < directions.length; k++) {
            setSeen(grid, i + directions[k][0], j + directions[k][1]);
        }
    }

}
