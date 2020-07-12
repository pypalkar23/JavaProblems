package leetcode;

public class UniquePaths2 {
    public static void main(String[] args) {
        int mat[][] = new int[][] { { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 0, 0 } };
        System.out.println(new UniquePaths2().uniquePathsWithObstacles2(mat));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[rows - 1][cols - 1] == 1)
            return 0;
        obstacleGrid[0][0] = 1;
        for (int i = 1; i < rows; i++) {
            if (obstacleGrid[i][0] == 1)
                break;
            obstacleGrid[i][0] = obstacleGrid[i - 1][0];
        }

        for (int i = 1; i < cols; i++) {
            if (obstacleGrid[0][i] == 1)
                break;
            obstacleGrid[0][i] = obstacleGrid[0][i - 1];
        }

        for (int i = 1; i < rows; i++)
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 1)
                    continue;

                if ((obstacleGrid[i - 1][j] == 1 || obstacleGrid[i][j - 1] == 1)
                        && obstacleGrid[i - 1][j] != obstacleGrid[i][j - 1])
                    obstacleGrid[i][j] = Math.min(obstacleGrid[i - 1][j], obstacleGrid[i][j - 1]);
                else if (obstacleGrid[i - 1][j] != 1 && obstacleGrid[i][j - 1] != 1)
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];

            }
        for (int row[] : obstacleGrid) {
            for (int col : row)
                System.out.print(col + " ");
            System.out.println("");
        }
        return -1 * obstacleGrid[rows - 1][cols - 1];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[rows - 1][cols - 1] == 1)
            return 0;
     
        for (int i = 0; i < rows; i++) {
            if (obstacleGrid[i][0] == 1) {
                obstacleGrid[i][0] = 0;
                break;
            }
            obstacleGrid[i][0] = 1;
        }

        for (int i = 0; i < cols; i++) {
            if (obstacleGrid[0][i] == 1) {
                obstacleGrid[0][i] = 0;
                break;
            }
            obstacleGrid[0][i] = 1;
        }

        for (int i = 1; i < rows; i++)
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[0][i] = 0;
                    continue;
                }

                obstacleGrid[i][j]=obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        for (int row[] : obstacleGrid) {
            for (int col : row)
                System.out.print(col + " ");
            System.out.println("");
        }
        return obstacleGrid[rows - 1][cols - 1];
    }

}