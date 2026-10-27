class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        
        // Base Case: If amount is 0, there is 1 way (take nothing)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        
        // Fill the DP table from bottom up (matching the recursive order)
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= amount; j++) {
                // Choice 1: Take current coin (if j >= coins[i], stay at index i)
                int take = 0;
                if (j >= coins[i]) {
                    take = dp[i][j - coins[i]];
                }
                
                // Choice 2: Skip current coin (move to i + 1)
                int skip = dp[i + 1][j];
                
                dp[i][j] = take + skip;
            }
        }
        
        return dp[0][amount];
    }
}