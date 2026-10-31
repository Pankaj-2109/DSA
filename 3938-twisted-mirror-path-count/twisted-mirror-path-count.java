import java.util.Arrays;

class Solution {
    static final int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][3];

        for (int[][] row2D : dp) {
            for (int[] row : row2D) {
                Arrays.fill(row, -1);
            }
        }

        for (int prev = 0; prev < 3; prev++) {
            dp[n - 1][m - 1][prev] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) continue;

                for (int pIdx = 0; pIdx < 3; pIdx++) {
                    int prev = pIdx - 1;
                    long right = 0;
                    long down = 0;

                    if (grid[i][j] == 1) {
                        if (prev == 0) {
                            if (i + 1 < n) down = dp[i + 1][j][2];
                        } else {
                            if (j + 1 < m) right = dp[i][j + 1][1];
                        }
                    } else {
                        if (i + 1 < n) down = dp[i + 1][j][2];
                        if (j + 1 < m) right = dp[i][j + 1][1];
                    }

                    dp[i][j][pIdx] = (int)((right + down) % MOD);
                }
            }
        }

        return dp[0][0][0];
    }
}