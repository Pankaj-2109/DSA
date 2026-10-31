import java.util.Arrays;

class Solution {
    static final int MOD = 1_000_000_007;

    public int solve(int i, int j, int prev, int[][] grid, int[][][] dp) {
        int n = grid.length;
        int m = grid[0].length;

        if (i < 0 || i >= n || j < 0 || j >= m) {
            return 0;
        }
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        if (dp[i][j][prev + 1] != -1) {
            return dp[i][j][prev + 1];
        }

        int right = 0;
        int down = 0;

        if (grid[i][j] == 1) {
            if (prev == 0) {
                down = solve(i + 1, j, 1, grid, dp);
            } else {
                right = solve(i, j + 1, 0, grid, dp);
            }
        } else {
            down = solve(i + 1, j, 1, grid, dp);
            right = solve(i, j + 1, 0, grid, dp);
        }

        return dp[i][j][prev + 1] = (int)(((long) right + down) % MOD);
    }

    public int uniquePaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // dp table of size n x m x 3 initialized with -1
        int[][][] dp = new int[n][m][3];
        for (int[][] row2D : dp) {
            for (int[] row : row2D) {
                Arrays.fill(row, -1);
            }
        }

        return solve(0, 0, -1, grid, dp);
    }
}