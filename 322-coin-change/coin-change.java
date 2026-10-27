class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        // dp[i][j] represents the minimum coins needed to make amount j using a subset of the first i coins
        int[][] dp = new int[m + 1][amount + 1];

        // Initialize base cases
        for (int j = 0; j <= amount; j++) {
            dp[0][j] = Integer.MAX_VALUE - 1; // Use MAX_VALUE - 1 to prevent overflow when adding 1
        }
        dp[0][0] = 0; // 0 coins needed to make amount 0

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] > j) {
                    // Coin value is greater than the current amount, exclude it
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Include the coin (unbounded knapsack: stay on row i) or exclude it
                    int include = (dp[i][j - coins[i - 1]] == Integer.MAX_VALUE - 1) ? 
                                  Integer.MAX_VALUE : 1 + dp[i][j - coins[i - 1]];
                    dp[i][j] = Math.min(dp[i - 1][j], include);
                }
            }
        }

        return dp[m][amount] == Integer.MAX_VALUE - 1 ? -1 : dp[m][amount];
    }
}