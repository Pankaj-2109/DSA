class Solution {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        int water = 0;

        for (int i = 0; i < height.length; i++) {

            // Current bar is the right boundary
            while (!st.isEmpty() && height[i] > height[st.peek()]) {

                int bottom = st.pop();

                // No left boundary
                if (st.isEmpty()) {
                    break;
                }

                int left = st.peek();

                // Width between left and right boundary
                int width = i - left - 1;

                // Height of water
                int h = Math.min(height[left], height[i]) - height[bottom];

                water += width * h;
            }

            st.push(i);
        }

        return water;
    }
}