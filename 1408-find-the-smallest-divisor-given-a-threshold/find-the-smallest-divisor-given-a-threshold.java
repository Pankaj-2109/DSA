
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int s = 1;
        int e = 0;

        for (int num : nums) {
            e = Math.max(e, num);
        }

        while (s <= e) {

            int mid = s + (e - s) / 2;

            int sum = 0;

            for (int i = 0; i < nums.length; i++) {
                sum += (nums[i] + mid - 1) / mid;
            }

            if (sum > threshold) {
                s = mid + 1;
            } 
            else {
                e = mid - 1;
            }
        }

        return s;
    }
}
