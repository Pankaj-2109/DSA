class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int sum = 0;

        target = Math.abs(target);

        for(int x : nums) {
            sum += x;
        }

        if((sum + target) % 2 != 0)
            return 0;

        int s1 = (sum + target) / 2;

        int[][] t = new int[n+1][s1 + 1];  // defaults to 0 in Java

        t[0][0] = 1; //if(n == 0) return target == 0 ? 1 : 0

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= s1; j++) {   // j starts at 0, not 1
                int skip = t[i-1][j];

                int take = 0;
                if(nums[i-1] <= j) {
                    take = t[i-1][j - nums[i-1]];
                }

                t[i][j] = (take + skip);
            }
        }

        return t[n][s1]; //return solve(n, s1)
    }
}
