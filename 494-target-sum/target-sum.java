class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(0, 0, nums, target);
    }
    
    private int solve(int i, int sum, int[] nums, int target) {
        // Base case: if we've processed all elements
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }
        
        // Choice 1: Add the current element (+nums[i])
        int add = solve(i + 1, sum + nums[i], nums, target);
        
        // Choice 2: Subtract the current element (-nums[i])
        int subtract = solve(i + 1, sum - nums[i], nums, target);
        
        // Return the total number of valid ways from both choices
        return add + subtract;
    }
}