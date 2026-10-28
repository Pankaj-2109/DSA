class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int[] t = new int[n];     // length of LIS ending at i
        int[] count = new int[n]; // number of LIS ending at i
        
        java.util.Arrays.fill(t, 1);
        java.util.Arrays.fill(count, 1);
        
        int maxLIS = 1;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (t[j] + 1 > t[i]) {
                        t[i] = t[j] + 1;
                        count[i] = count[j]; // Reset count to the incoming path count
                    } else if (t[j] + 1 == t[i]) {
                        count[i] += count[j]; // Accumulate count from alternative path
                    }
                }
            }
            maxLIS = Math.max(maxLIS, t[i]);
        }
        
        int ans = 0;
        for (int k = 0; k < n; k++) {
            if (t[k] == maxLIS) {
                ans += count[k]; // Sum up all counts matching the max length
            }
        }
        
        return ans;
    }
}