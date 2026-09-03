class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        boolean allEven = true;

        for (int num : nums1) {
            min = Math.min(min, num);

            if ((num & 1) != 0) {
                allEven = false;
            }
        }

        // Possible when:
        // 1. Every element is even, or
        // 2. The minimum element is odd.
        return allEven || (min & 1) != 0;
    }
}