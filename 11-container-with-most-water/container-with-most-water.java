
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int s = 0;
        int e = n - 1;
        int water = 0;

        while (s < e) {
            int l = Math.min(height[s], height[e]);
            int b = e - s;

            int area = l * b;
            water = Math.max(water, area);

            if (height[s] < height[e]) {
                s++;
            } else {
                e--;
            }
        }

        return water;
    }
}
