import java.util.Arrays;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        
        // Precompute divisors for each length up to n
        // divisors[len] will store all proper divisors of len
        @SuppressWarnings("unchecked")
        java.util.List<Integer>[] divisors = new java.util.List[n + 1];
        for (int i = 1; i <= n; i++) {
            divisors[i] = new java.util.ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 2 * i; j <= n; j += i) {
                divisors[j].add(i);
            }
        }
        
        // cost[i][j] = minimum changes to make s[i...j] a semi-palindrome
        int[][] cost = new int[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                int minChanges = Integer.MAX_VALUE;
                
                // Try each proper divisor d of len
                for (int d : divisors[len]) {
                    int currentChanges = 0;
                    // Check each of the d groups
                    for (int offset = 0; offset < d; offset++) {
                        // Count mismatches in the group starting at 'offset' with step 'd'
                        int l = i + offset;
                        int r = i + ((len - 1) / d) * d + offset; // last element of this group
                        while (l < r) {
                            if (arr[l] != arr[r]) {
                                currentChanges++;
                            }
                            l += d;
                            r -= d;
                        }
                    }
                    minChanges = Math.min(minChanges, currentChanges);
                }
                cost[i][j] = minChanges;
            }
        }
        
        // dp[i][j] = min changes to partition prefix of length i into j semi-palindromes
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], 1_000_000);
        }
        dp[0][0] = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                for (int p = j - 1; p < i; p++) {
                    if (dp[p][j - 1] != 1_000_000 && cost[p][i - 1] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[p][j - 1] + cost[p][i - 1]);
                    }
                }
            }
        }
        
        return dp[n][k];
    }
}