class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int total = 0;
        for (int x : cardPoints) {
            total += x;
        }

        int window = 0;

        // First window of size n-k
        for (int i = 0; i < n - k; i++) {
            window += cardPoints[i];
        }

        int minWindow = window;

        // Sliding window
        for (int i = n - k; i < n; i++) {
            window += cardPoints[i];
            window -= cardPoints[i - (n - k)];

            minWindow = Math.min(minWindow, window);
        }

        return total - minWindow;
    }
}