class Solution {
    public boolean isSubsetSum(int[] arr, int sum) {
        int n = arr.length;

        boolean[][] t = new boolean[n + 1][sum + 1];

        // Base case: sum = 0 is always possible
        for (int i = 0; i <= n; i++) {
            t[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {

                boolean skip = t[i - 1][j];

                boolean take = false;
                if (arr[i - 1] <= j) {
                    take = t[i - 1][j - arr[i - 1]];
                }

                t[i][j] = take || skip;
            }
        }

        return t[n][sum];
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int SUM = 0;
        for (int num : nums)
            SUM += num;

        if (SUM % 2 != 0)
            return false;

        int S = SUM / 2;

        return isSubsetSum(nums, S);
    }
}