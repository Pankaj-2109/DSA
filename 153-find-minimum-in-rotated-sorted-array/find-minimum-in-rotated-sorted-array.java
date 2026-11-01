class Solution {
    public int findMin(int[] nums) {
        int piv=findpivot(nums);
        return nums[piv];

        
    }
    static int findpivot(int[] nums) {
        int n = nums.length;
        int s = 0;
        int e = n - 1;
        int ans = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] <= nums[n - 1]) {
                // mid is on line 2
                // answer lies on the left side
                ans = mid;
                e = mid - 1;
            } 
            else {
                // mid is on line 1
                s = mid + 1;
            }
        }

        return ans;
    }
}