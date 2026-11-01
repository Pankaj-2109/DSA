class Solution {
    public int findPeakElement(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        
        while (s < e) {
            int mid = s + (e - s) / 2;
            
            // If mid element is smaller than the next, peak is on the right
            if (nums[mid] < nums[mid + 1]) {
                s = mid + 1;
            } 
            // Otherwise, peak is at mid or on the left
            else {
                e = mid;
            }
        }
        
        // When s and e converge, we've found our peak
        return s;
    }
}