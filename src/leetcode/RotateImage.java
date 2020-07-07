package leetcode;

/*48. Rotate Image*/
public class RotateImage {
    public static void main(String[] args) {
        int mat[][] = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        new RotateImage().rotate(mat);
        for (int row[] : mat) {
            for (int i : row)
                System.out.print(i + " ");
            System.out.println("");
        }
    }

    public void rotate(int[][] matrix) {
        if (matrix == null)
            return;
        if (matrix.length == 0 || matrix[0].length == 0)
            return;

        int n = matrix.length, k = 0, i = 0;
        for (i = 0; i < n / 2; i++) {
            int temp[] = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = temp;
        }

        for (i = 0; i < n; i++) {
            for (k = i; k < n; k++) {
                int temp = matrix[i][k];
                matrix[i][k] = matrix[k][i];
                matrix[k][i] = temp;
            }

        }

    }
}