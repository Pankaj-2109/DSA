
class Solution {
    public boolean isSubsequence(String s, String t) {
        int M = s.length();
        int N = t.length();

        if (M > N) {
            return false;
        }

        int i = 0, j = 0;

        while (i < M && j < N) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == M;
    }
}
