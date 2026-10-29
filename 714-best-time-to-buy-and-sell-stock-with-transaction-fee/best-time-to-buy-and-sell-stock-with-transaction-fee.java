import java.util.Arrays;

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, 1, prices, dp, fee);
    }
    
    int solve(int i, int buy, int[] prices, int[][] dp, int fee) {
        if (i == prices.length) {
            return 0;
        }
        
        if (dp[i][buy] != -1) {
            return dp[i][buy];
        }
        
        int profit = 0;
        if (buy == 1) {
            int buyStock = -prices[i] + solve(i + 1, 0, prices, dp, fee);
            int skipBuy = solve(i + 1, 1, prices, dp, fee);
            profit = Math.max(buyStock, skipBuy);
        } else {
            int sellStock = prices[i] - fee + solve(i + 1, 1, prices, dp, fee);
            int holdStock = solve(i + 1, 0, prices, dp, fee);
            profit = Math.max(sellStock, holdStock);
        }
        
        return dp[i][buy] = profit;
    }
}