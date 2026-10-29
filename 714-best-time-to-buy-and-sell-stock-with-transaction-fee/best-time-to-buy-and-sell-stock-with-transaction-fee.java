class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if (buy == 1) {
                    int buyStock = -prices[i] + dp[i + 1][0];
                    int skipBuy = dp[i + 1][1];
                    profit = Math.max(buyStock, skipBuy);
                } else {
                    int sellStock = prices[i] - fee + dp[i + 1][1];
                    int holdStock = dp[i + 1][0];
                    profit = Math.max(sellStock, holdStock);
                }
                dp[i][buy] = profit;
            }
        }
        
        return dp[0][1];
    }
}