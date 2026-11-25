class Solution {
    public int numTrees(int n) {
        long ans = 1;

        for (int i = 1; i <= n; i++) {
            ans = ans * (4 * i - 2) / (i + 1);
        }

        return (int) ans;
    }
}