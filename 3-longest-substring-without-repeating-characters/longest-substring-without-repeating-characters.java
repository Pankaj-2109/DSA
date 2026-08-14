class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int ans = 0;

        for (int r = 0; r < s.length(); r++) {

            for (int j = l; j < r; j++) {
                if (s.charAt(j) == s.charAt(r)) {
                    l = j + 1;
                    break;
                }
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}