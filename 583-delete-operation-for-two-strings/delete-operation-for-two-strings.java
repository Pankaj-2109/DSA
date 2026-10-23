class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // dp[i][j] represents the minimum steps to make word1[0...i-1] and word2[0...j-1] the same
        int[][] dp = new int[m + 1][n + 1];
        
        // 1. Initialize base cases: if one string is empty, delete all characters from the other
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        
        // 2. Fill the table bottom-up
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match, no deletion needed for this pair
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Otherwise, take the minimum of deleting from word1 or word2
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // 3. The answer for full strings is at the bottom-right corner
        return dp[m][n];
    }
}