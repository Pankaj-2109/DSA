
import java.util.Arrays;

class Solution {
    public int solve(int i, int[] costs, int[] dp) {
        int n = costs.length;

        if (i == n) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int p1 = Integer.MAX_VALUE;
        int p2 = Integer.MAX_VALUE;
        int p3 = Integer.MAX_VALUE;

        if (i + 1 <= n) {
            p1 = costs[i] + 1 + solve(i + 1, costs, dp);
        }

        if (i + 2 <= n) {
            p2 = costs[i + 1] + 4 + solve(i + 2, costs, dp);
        }

        if (i + 3 <= n) {
            p3 = costs[i + 2] + 9 + solve(i + 3, costs, dp);
        }

        return dp[i] = Math.min(p1, Math.min(p2, p3));
    }

    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(0, costs, dp);
    }
}
