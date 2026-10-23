import java.util.Arrays;

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        
        // 1. Initialize the DP table with -1 (since 0 is a valid cached answer)
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return solve(word1, word2, m - 1, n - 1, dp);
    }
    
    int solve(String word1, String word2, int i, int j, int[][] dp) {
        // 2. Base cases come BEFORE checking or writing to dp
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }
        
        // 3. Check if already computed
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        // 4. Transition and store in dp
        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = solve(word1, word2, i - 1, j - 1, dp);
        } else {
            return dp[i][j] = Math.min(
                1 + solve(word1, word2, i - 1, j, dp), 
                1 + solve(word1, word2, i, j - 1, dp)
            );
        }
    }
}