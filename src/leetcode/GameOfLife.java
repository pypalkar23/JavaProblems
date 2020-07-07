package leetcode;

/*289. Game of Life*/
public class GameOfLife {
    public static void main(String[] args) {
        int mat[][] = new int[][] { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
        new GameOfLife().gameOfLife(mat);
        System.out.println("-----------");
        for (int row[] : mat) {
            for (int i : row)
                System.out.print(i + " ");
            System.out.println("");
        }

    }

    //in-place approach
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;

        int neighbourbits[] = new int[] { -1, 0, 1 };
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                // iterate over a neighbour of every cell
                int liveneighbours = 0;
                for (int k = 0; k < 3; k++) {
                    int nx = i + neighbourbits[k];
                    for (int l = 0; l < 3; l++) {
                        int ny = j + neighbourbits[l];
                        if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && !(nx == i && ny == j)
                                && Math.abs(board[nx][ny]) == 1) {
                            liveneighbours++;
                        }
                    }
                }

                // conditions
                // rule 1 & 3
                if (board[i][j] == 1 && (liveneighbours < 2 || liveneighbours > 3))
                    // marking dead but was alive earlier. will be counted in other cells survival
                    // calculation.
                    board[i][j] = -1;
                // rule 4
                else if (board[i][j] == 0 && liveneighbours == 3)
                    // marking alive but dead earlier. wont be counted in other cells survival
                    // calculation
                    board[i][j] = 2;

            }
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                board[i][j] = (board[i][j] > 0) ? 1 : 0;
    }

    // array copying approach
    public void gameOfLife1(int[][] board) {

        if (board == null || board.length == 0 || board[0].length == 0)
            return;

        int neighbourbits[] = new int[] { -1, 0, 1 };
        int rows = board.length;
        int cols = board[0].length;

        int boardCopy[][] = new int[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                boardCopy[i][j] = board[i][j];
            }
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                // iterate over a neighbour of every cell
                int liveneighbours = 0;
                for (int k = 0; k < 3; k++) {
                    int nx = i + neighbourbits[k];
                    for (int l = 0; l < 3; l++) {
                        int ny = j + neighbourbits[l];
                        if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && !(nx == i && ny == j)
                                && boardCopy[nx][ny] == 1) {
                            liveneighbours++;
                        }
                    }
                }

                // conditions
                // rule 1 & 3

                if (liveneighbours < 2 || liveneighbours > 3)
                    board[i][j] = 0;
                // rule 4
                else if (boardCopy[i][j] == 0 && liveneighbours == 3)
                    board[i][j] = 1;

            }

    }

}