class Solution {
    public boolean canEatAll(int[] piles, int givenHour, int h) {
        long actualHour = 0; // Use long to prevent integer overflow for large inputs
        
        for (int x : piles) {
            actualHour += x / givenHour;
            
            if (x % givenHour != 0) {
                actualHour++;
            }
        }
        
        return actualHour <= h;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        
        // Find the maximum element in piles to set the right bound
        for (int x : piles) {
            if (x > r) {
                r = x;
            }
        }
        
        while (l < r) {
            int mid = l + (r - l) / 2;
            
            if (canEatAll(piles, mid, h)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        return l;
    }
}