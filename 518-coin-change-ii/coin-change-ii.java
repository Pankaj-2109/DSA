class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        
        // Initialize dp table with -1 to mark states as uncomputed
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return solve(0, amount, coins, dp);
    }
    
    private int solve(int i, int amount, int[] coins, int[][] dp) {
        // Base cases
        if (amount == 0) {
            return 1; // Found a valid combination
        }
        if (amount < 0 || i == coins.length) {
            return 0; // Invalid path or ran out of coins
        }
        
        // Check if already computed
        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }
        
        // Choice 1: Take the current coin (stay at index i for unlimited reuse)
        int take = solve(i, amount - coins[i], coins, dp);
        
        // Choice 2: Skip the current coin (move to the next coin index i + 1)
        int skip = solve(i + 1, amount, coins, dp);
        
        // Store in dp table and return
        return dp[i][amount] = take + skip;
    }
}