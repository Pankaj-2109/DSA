class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;

        long sum = 0;
        for (int x : nums) {
            sum += x;
        }

        int minEl = Integer.MAX_VALUE;
        for (int x : nums) {
            minEl = Math.min(minEl, x);
        }

        return (int) (sum - (long) n * minEl);
    }
}