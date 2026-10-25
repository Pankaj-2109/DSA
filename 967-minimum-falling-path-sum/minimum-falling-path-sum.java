class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[][] dp = new int[n][m];
        
        for (int i = 0; i < m; i++) {
            dp[0][i] = matrix[0][i];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int minValue = Integer.MAX_VALUE;
                
                if (i - 1 >= 0) {
                    minValue = Math.min(minValue, dp[i - 1][j]);
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    minValue = Math.min(minValue, dp[i - 1][j - 1]);
                }
                if (i - 1 >= 0 && j + 1 < m) {
                    minValue = Math.min(minValue, dp[i - 1][j + 1]);
                }
                
                dp[i][j] = minValue + matrix[i][j];
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, dp[n - 1][j]);
        }
        
        return ans;
    }
}