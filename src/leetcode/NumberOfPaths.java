import java.util.List;

class NumberOfPaths {
    public static int numberOfPaths(List<List<Integer>> a) {
        // Write your code here
        int m = a.size();
        int n = a.get(0).size();

        if (a.get(0).get(0) == 0)
            return 0;

        if (a.get(m - 1).get(n - 1) == 0)
            return 0;

        int[][] paths = new int[m][n];
        paths[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (a.get(i).get(0) == 0)
                paths[i][0] = 0;
            else
                paths[i][0] = paths[i - 1][0];
        }

        for (int i = 1; i < n; i++) {
            if (a.get(0).get(i) == 0)
                paths[0][i] = 0;
            else
                paths[0][i] = paths[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (a.get(i).get(j) == 0) {
                    paths[i][j] = 0;
                } else {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }

            }
        }

        return paths[m - 1][n - 1];

    }
}