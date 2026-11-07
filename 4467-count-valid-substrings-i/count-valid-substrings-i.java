class Solution {
    public long countValidSubstrings(String s) {
        int n = s.length();
        int left = 0;
        long ans = 0;

        for (int right = 0; right < n; right++) {

            while (right - left >= 2 &&
                   s.substring(right - 2, right + 1).equals("abc")) {
                left = right - 1;
            }

            ans += right - left + 1;
        }

        return ans;
    }
}