class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        // Step 1: Traverse border cells and start DFS for any 'O' found
        // Top and Bottom borders
        for (int c = 0; c < cols; c++) {
            if (board[0][c] == 'O') {
                dfs(board, 0, c);
            }
            if (board[rows - 1][c] == 'O') {
                dfs(board, rows - 1, c);
            }
        }

        // Left and Right borders
        for (int r = 0; r < rows; r++) {
            if (board[r][0] == 'O') {
                dfs(board, r, 0);
            }
            if (board[r][cols - 1] == 'O') {
                dfs(board, r, cols - 1);
            }
        }

        // Step 2: Traverse the entire grid and resolve the cells
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X'; // Surrounded 'O' -> captured
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O'; // Safe border-connected 'O' -> restored
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        int rows = board.length;
        int cols = board[0].length;

        // Base cases: out of bounds or cell is not 'O'
        if (r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != 'O') {
            return;
        }

        // Mark this safe 'O' as temporary character 'T'
        board[r][c] = 'T';

        // Explore all 4 orthogonal directions
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}