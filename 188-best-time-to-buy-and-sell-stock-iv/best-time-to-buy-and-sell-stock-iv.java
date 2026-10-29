class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) {
            return 0;
        }
        
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        
        int[][][] dp = new int[n + 1][2][k + 1];
        
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) {
                    int profit = 0;
                    if (buy == 1) {
                        int buyStock = -prices[i] + dp[i + 1][0][cap];
                        int skipBuy = dp[i + 1][1][cap];
                        profit = Math.max(buyStock, skipBuy);
                    } else {
                        int sellStock = prices[i] + dp[i + 1][1][cap - 1];
                        int holdStock = dp[i + 1][0][cap];
                        profit = Math.max(sellStock, holdStock);
                    }
                    dp[i][buy][cap] = profit;
                }
            }
        }
        
        return dp[0][1][k];
    }
}