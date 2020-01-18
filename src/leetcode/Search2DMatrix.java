package leetcode;
class Search2DMatrix {
    /* Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom. */

    public boolean searchMatrixLeetcodeSoln(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int col = matrix[0].length - 1;
        int row = 0;
        while (col >= 0 && row <= matrix.length - 1) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        if (rows == 0)
            return false;
        int columns = matrix[0].length;
        if (columns == 0)
            return false;
        //return searchMatrixUtil(matrix, target, 0, 0, rows - 1, columns - 1);
        return searchMatrixUtil2(matrix, target, rows-1, columns-1);
    }

    public boolean searchMatrixUtil(int[][] matrix, int target, int topx, int topy, int bottomx, int bottomy) {
        System.out.println(String.format("In searchMatrixUtil topx: %d topy: %d bottomx: %d, bottomy: %d", topx, topy,
                bottomx, bottomy));
        if (topx > bottomx || topy > bottomy)
            return false;

        if (matrix[topx][topy] == target || matrix[topx][bottomy] == target || matrix[bottomx][topy] == target
                || matrix[bottomx][bottomy] == target)
            return true;

        /*  if (topx == bottomx) {
            return binarySearchUtil(matrix[topx], target, topx, bottomx);
        } */

        if (target > matrix[topx][topy] && target > matrix[topx][bottomy])
            topx += 1;
        else if (target < matrix[bottomx][bottomy] && target < matrix[bottomx][topy])
            bottomx -= 1;
        else if (target > matrix[topx][topy])
            topy += 1;
        else if (target < matrix[bottomx][topy])
            bottomy -= 1;

        return searchMatrixUtil(matrix, target, topx, topy, bottomx, bottomy);
    }

    public boolean searchMatrixUtil2(int[][] matrix, int target, int rows, int col) {
        int i = 0;
        while (i < rows+1) {
            if (matrix[i][0] > target)
                return false;
            if (target == matrix[i][0] || target == matrix[i][col])
                return true;
            else if (target > matrix[i][0] && target < matrix[i][col])
                if (binarySearchUtil(matrix[i], target, 0, col))
                    return true;
            i++;
        }
        return false;
    }

    public boolean binarySearchUtil(int[] row, int target, int low, int high) {
        /*System.out.println("in Binary Search");*/
        int mid = 0;
        while (low <= high) {
            System.out.println(low+" "+high);
            mid = (low + high) / 2;
            if (row[mid] == target) {
                return true;
            } else {
                if (row[mid] > target) {
                    high = mid - 1;
                } else
                    low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        /* int a[][] = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 } }; */
        int a[][] = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
        //int a[][]={{1}};
        int target = 2;
        Search2DMatrix sMatrix = new Search2DMatrix();
        System.out.println(sMatrix.searchMatrix(a, 5));
    }
}