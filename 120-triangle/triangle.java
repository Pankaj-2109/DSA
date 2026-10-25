class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] t = new int[n][n];

        // Copy triangle into t
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                t[i][j] = triangle.get(i).get(j);
            }
        }

        // Bottom-up calculation
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                t[row][col] += Math.min(t[row + 1][col], t[row + 1][col + 1]);
            }
        }

        return t[0][0];
    }
}
