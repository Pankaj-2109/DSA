class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {

            int curr = (i == n) ? 0 : heights[i];

            while (!st.isEmpty() && heights[st.peek()] > curr) {

                int h = heights[st.pop()];

                int width;

                if (st.isEmpty()) {
                    width = i;
                } else {
                    width = i - st.peek() - 1;
                }

                maxArea = Math.max(maxArea, h * width);
            }

            st.push(i);
        }

        return maxArea;
    }
}