class Solution {
    static boolean solve(String s, int index, List<String> wordDict, Boolean[] dp) {
        if (index == s.length()) {
            return true;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String word = s.substring(index, i);

            if (wordDict.contains(word) && solve(s, i, wordDict, dp)) {
                return dp[index] = true;
            }
        }

        return dp[index] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return solve(s, 0, wordDict, dp);
    }
}