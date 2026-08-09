import java.util.*;

class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        boolean[][] board = new boolean[n][n];

        queens(board, 0, result);

        return result;
    }

    private void queens(boolean[][] board, int row,
                         List<List<String>> result) {

        // All queens have been placed
        if (row == board.length) {
            result.add(createBoard(board));
            return;
        }

        // Try every column in this row
        for (int col = 0; col < board.length; col++) {

            if (isSafe(board, row, col)) {

                board[row][col] = true;

                queens(board, row + 1, result);

                // Backtrack
                board[row][col] = false;
            }
        }
    }

    private boolean isSafe(boolean[][] board, int row, int col) {

        // Check column
        for (int r = 0; r < row; r++) {
            if (board[r][col]) {
                return false;
            }
        }

        // Check upper-left diagonal
        int maxLeft = Math.min(row, col);

        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        // Check upper-right diagonal
        int maxRight = Math.min(row, board.length - col - 1);

        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }

        return true;
    }

    private List<String> createBoard(boolean[][] board) {

        List<String> configuration = new ArrayList<>();

        for (boolean[] row : board) {

            StringBuilder sb = new StringBuilder();

            for (boolean cell : row) {
                if (cell) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }

            configuration.add(sb.toString());
        }

        return configuration;
    }
}