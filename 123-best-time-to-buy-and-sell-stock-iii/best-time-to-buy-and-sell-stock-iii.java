import java.util.Arrays;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }
        return solve(0, 1, 2, prices, dp);
    }
    
    int solve(int i, int buy, int cap, int[] prices, int[][][] dp) {
        if (i == prices.length || cap == 0) {
            return 0;
        }
        
        if (dp[i][buy][cap] != -1) {
            return dp[i][buy][cap];
        }
        
        int profit = 0;
        if (buy == 1) {
            int buyStock = -prices[i] + solve(i + 1, 0, cap, prices, dp);
            int skipBuy = solve(i + 1, 1, cap, prices, dp);
            profit = Math.max(buyStock, skipBuy);
        } else {
            int sellStock = prices[i] + solve(i + 1, 1, cap - 1, prices, dp);
            int holdStock = solve(i + 1, 0, cap, prices, dp);
            profit = Math.max(sellStock, holdStock);
        }
        
        return dp[i][buy][cap] = profit;
    }
}