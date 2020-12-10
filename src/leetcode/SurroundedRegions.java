package leetcode;

public class SurroundedRegions {
    // vertical or horizontal connections are allowed
    int[][] directions = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

    public static void main(String[] args) {
        char board[][] = { { 'X', 'X', 'X', 'X', }, { 'X', 'O', 'O', 'X', }, { 'X', 'X', 'O', 'X', },
                { 'X', 'O', 'X', 'X', } };

        new SurroundedRegions().solve(board);
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;

        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O')
                markSafe(board, i, 0);
            if (board[i][board[0].length - 1] == 'O')
                markSafe(board, i, board[0].length - 1);
        }

        for (int i = 1; i < board[0].length - 1; i++) {
            if (board[0][i] == 'O')
                markSafe(board, 0, i);
            if (board[board[0].length - 1][i] == 'O')
                markSafe(board, board[0].length - 1, i);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = (board[i][j] != 'S') ? 'X' : 'O';
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }

    }

    public void markSafe(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 'X' || board[i][j] == 'S')
            return;
        board[i][j] = 'S';// S for safe
        // recursively checking adjecent cells for land
        for (int k = 0; k < directions.length; k++) {
            markSafe(board, i + directions[k][0], j + directions[k][1]);
        }
    }
}
