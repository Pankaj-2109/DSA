import java.util.Arrays;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int[] t = new int[n];
        int[] count = new int[n];
        
        Arrays.fill(t, 1);
        Arrays.fill(count, 1);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (t[i] == t[j] + 1) {
                        count[i] += count[j];
                    } else if (t[i] < t[j] + 1) {
                        t[i] = t[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
        }
        
        int maxVal = 0;
        for (int val : t) {
            maxVal = Math.max(maxVal, val);
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (t[i] == maxVal) {
                result += count[i];
            }
        }
        
        return result;
    }
}