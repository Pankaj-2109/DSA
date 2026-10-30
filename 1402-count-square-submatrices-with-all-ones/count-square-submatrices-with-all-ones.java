import java.util.Arrays;

class Solution {
    int m, n;

    public int solve(int i, int j, int[][] grid, int[][] dp) {

        if (i >= m || j >= n)
            return 0;

        if (grid[i][j] == 0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int right = solve(i, j + 1, grid, dp);
        int diagonal = solve(i + 1, j + 1, grid, dp);
        int below = solve(i + 1, j, grid, dp);

        return dp[i][j] = 1 + Math.min(right, Math.min(diagonal, below));
    }

    public int countSquares(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result += solve(i, j, grid, dp);
            }
        }

        return result;
    }
}