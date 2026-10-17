class Solution {
    int n;
    long[][] t;

    long solve(int idx, int[] nums, boolean isEven) {
        if (idx >= n) {
            return 0;
        }

        int state = isEven ? 1 : 0;

        if (t[idx][state] != -1) {
            return t[idx][state];
        }

        long skip = solve(idx + 1, nums, isEven);

        long val = nums[idx];

        if (!isEven) {
            val = -val;
        }

        long take = solve(idx + 1, nums, !isEven) + val;

        return t[idx][state] = Math.max(skip, take);
    }

    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        t = new long[n][2];

        for (long[] row : t) {
            Arrays.fill(row, -1);
        }

        return solve(0, nums, true);
    }
}