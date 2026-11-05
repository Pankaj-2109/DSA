class Solution {

    public int splitArray(int[] nums, int k) {

        int low = 0;
        int high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int count = noOfSubarrays(nums, mid);

            if (count > k) {
                low = mid + 1;
            } 
            else {
                ans = mid;
                high = mid - 1;
            }
        }

        return ans;
    }

    private int noOfSubarrays(int[] nums, int mid) {

        int sum = 0;
        int count = 1;

        for (int num : nums) {

            if (sum + num > mid) {
                count++;
                sum = num;
            } 
            else {
                sum += num;
            }
        }

        return count;
    }
}