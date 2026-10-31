import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // dp[i][j][dir]: dir 0 for coming from left (moving right), dir 1 for coming from top (moving down)
        int[][][] dp = new int[m][n][2];
        for (int[][] row2D : dp) {
            for (int[] row : row2D) {
                Arrays.fill(row, -1);
            }
        }

        return solve(0, 0, 0, grid, dp);
    }

    private int solve(int i, int j, int dir, int[][] grid, int[][][] dp) {
        int m = grid.length;
        int n = grid[0].length;

        if (i >= m || j >= n) {
            return 0;
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j][dir] != -1) {
            return dp[i][j][dir];
        }

        long totalPaths = 0;

        // From an empty cell (i, j), the robot can choose to move Right or Down.
        // However, if we are at the start (0,0), we branch into the two initial moves:
        if (i == 0 && j == 0 && dir == 0) {
            totalPaths = (getValidPathsAfterMove(0, 1, 0, grid, dp) + 
                          getValidPathsAfterMove(1, 0, 1, grid, dp)) % MOD;
        } else {
            // Standard state transition
            int nextR = (dir == 0) ? j + 1 : j;
            int nextC = (dir == 0) ? i : i + 1;
            // Wait, let's use the helper to simulate the next steps properly
        }

        return dp[i][j][dir] = (int) totalPaths;
    }

    private long getValidPathsAfterMove(int i, int j, int dir, int[][] grid, int[][][] dp) {
        int m = grid.length;
        int n = grid[0].length;

        // Simulate reflection chain
        while (i < m && j < n && grid[i][j] == 1) {
            if (dir == 0) {
                // Moving right into mirror -> turn down
                i += 1;
                dir = 1;
            } else {
                // Moving down into mirror -> turn right
                j += 1;
                dir = 0;
            }
        }

        if (i >= m || j >= n) {
            return 0;
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j][dir] != -1) {
            return dp[i][j][dir];
        }

        // From this new empty cell, we can move Right (dir=0) or Down (dir=1)
        long rightPaths = getValidPathsAfterMove(i, j + 1, 0, grid, dp);
        long downPaths = getValidPathsAfterMove(i + 1, j, 1, grid, dp);

        return dp[i][j][dir] = (int)((rightPaths + downPaths) % MOD);
    }
}