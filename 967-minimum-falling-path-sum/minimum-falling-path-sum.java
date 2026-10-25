class Solution {
    int[][] dp;

    int solve(int[][] matrix, int i, int j, int n) {

        if (j < 0 || j >= n) {
            return (int)1e9; // invalid path
        }

        if (i == n - 1) {
            return matrix[i][j];
        }

        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }

        int downLeft = solve(matrix, i + 1, j - 1, n);
        int down = solve(matrix, i + 1, j, n);
        int downRight = solve(matrix, i + 1, j + 1, n);

        return dp[i][j] =
                matrix[i][j] + Math.min(downLeft, Math.min(down, downRight));
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, solve(matrix, 0, j, n));
        }

        return ans;
    }
}