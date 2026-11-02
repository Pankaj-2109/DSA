class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 1;
        long right = (long) Arrays.stream(time).min().getAsInt() * totalTrips;
        
        while (left < right) {
            long mid = left + (right - left) / 2;
            
            if (possible(time, mid, totalTrips)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }

    private boolean possible(int[] time, long givenTime, int totalTrips) {
        long actualTrips = 0;
        
        for (int t : time) {
            actualTrips += givenTime / t;
            if (actualTrips >= totalTrips) {
                return true;  // Early exit if we already have enough trips
            }
        }
        
        return actualTrips >= totalTrips;
    }
}