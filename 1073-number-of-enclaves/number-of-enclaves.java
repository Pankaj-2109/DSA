class Solution {

    int m, n;

    void dfs(int[][] grid, int r, int c) {

        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0) {
            return;
        }

        // Mark as visited
        grid[r][c] = 0;

        // Left
        dfs(grid, r, c - 1);

        // Right
        dfs(grid, r, c + 1);

        // Up
        dfs(grid, r - 1, c);

        // Down
        dfs(grid, r + 1, c);
    }

    public int numEnclaves(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        // Remove land connected to the first and last columns
        for (int i = 0; i < m; i++) {

            if (grid[i][0] == 1) {
                dfs(grid, i, 0);
            }

            if (grid[i][n - 1] == 1) {
                dfs(grid, i, n - 1);
            }
        }

        // Remove land connected to the first and last rows
        for (int i = 0; i < n; i++) {

            if (grid[0][i] == 1) {
                dfs(grid, 0, i);
            }

            if (grid[m - 1][i] == 1) {
                dfs(grid, m - 1, i);
            }
        }

        // Count remaining land cells
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
