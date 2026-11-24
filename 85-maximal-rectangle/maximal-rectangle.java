
class Solution {
    public int maximalRectangle(char[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];

        int maxArea = 0;

        for (int i = 0; i < rows; i++) {

            // Build histogram for current row
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            // Largest Rectangle using Stack (LC 84)
            Stack<Integer> st = new Stack<>();

            for (int j = 0; j <= cols; j++) {

                int currHeight = (j == cols) ? 0 : heights[j];

                while (!st.isEmpty() &&
                       heights[st.peek()] >= currHeight) {

                    int height = heights[st.pop()];

                    int pse = st.isEmpty() ? -1 : st.peek();
                    int nse = j;

                    int width = nse - pse - 1;

                    int area = height * width;

                    maxArea = Math.max(maxArea, area);
                }

                if (j < cols) {
                    st.push(j);
                }
            }
        }

        return maxArea;
    }
}
