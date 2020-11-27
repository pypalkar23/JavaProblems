
package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*36. Valid Sudoku*/
public class ValidSudoku {
    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> matMap = new HashMap<>();
        int i = 0, j = 0;
        // the idea is too assign numbers to submatrix like 2d array indexes
        // e.g first matrix in first row is 00, first matrix in second row 10
        int currentMatrixRow = 0;
        int currentMatrixCol = 0;
        for (i = 0; i < 9; i++) {
            currentMatrixRow = i / 3;
            for (j = 0; j < 9; j++) {
                currentMatrixCol = j / 3;
                if (board[i][j] != '.') {
                    // check for column validity
                    if (checkInHashtable(colMap, j, board[i][j])) {
                        return false;
                    }
                    // check for row validity
                    if (checkInHashtable(rowMap, i, board[i][j])) {
                        return false;
                    }
                    // check for sub matrix validity
                    int matKey = currentMatrixRow * 10 + currentMatrixCol;
                    if (checkInHashtable(matMap, matKey, board[i][j]))
                        return false;
                }
            }
        }
        return true;

    }

    public boolean checkInHashtable(Map<Integer, Set<Character>> hMap, int key, char value) {
        Set<Character> s = null;
        if (hMap.containsKey(key)) {
            s = hMap.get(key);
            if (s.contains(value))
                return true;
        }
        if (s == null) {
            s = new HashSet<Character>();
        }
        s.add(value);
        hMap.put(key, s);
        return false;
    }
}