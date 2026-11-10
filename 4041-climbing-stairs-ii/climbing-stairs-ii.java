
class Solution {
    public int climbStairs(int n, int[] costs) {

        int[] dp = new int[n + 1];

        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {

            int p1 = Integer.MAX_VALUE;
            int p2 = Integer.MAX_VALUE;
            int p3 = Integer.MAX_VALUE;

            if (i + 1 <= n) {
                p1 = costs[i] + 1 + dp[i + 1];
            }

            if (i + 2 <= n) {
                p2 = costs[i + 1] + 4 + dp[i + 2];
            }

            if (i + 3 <= n) {
                p3 = costs[i + 2] + 9 + dp[i + 3];
            }

            dp[i] = Math.min(p1, Math.min(p2, p3));
        }

        return dp[0];
    }
}
