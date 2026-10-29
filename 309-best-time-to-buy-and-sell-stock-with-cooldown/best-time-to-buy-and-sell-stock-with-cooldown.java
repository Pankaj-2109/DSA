class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];
        
        for (int i = n - 1; i >= 0; i--) {
            for (int bag = 0; bag <= 1; bag++) {
                int profit = 0;
                if (bag == 1) {
                    int op2 = prices[i] + dp[i + 2][0];
                    int op3 = dp[i + 1][1];
                    profit = Math.max(op2, op3);
                } else {
                    int op1 = -prices[i] + dp[i + 1][1];
                    int op3 = dp[i + 1][0];
                    profit = Math.max(op1, op3);
                }
                dp[i][bag] = profit;
            }
        }
        
        return dp[0][0];
    }
}