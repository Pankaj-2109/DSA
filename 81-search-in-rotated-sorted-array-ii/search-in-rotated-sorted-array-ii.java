class Solution {

    public boolean search(int[] nums, int target) {

        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {

            int mid = s + (e - s) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // Cannot identify which half is sorted
            if (nums[s] == nums[mid] && nums[mid] == nums[e]) {
                s++;
                e--;
            }

            // Left half is sorted
            else if (nums[s] <= nums[mid]) {

                if (target >= nums[s] && target < nums[mid]) {
                    e = mid - 1;
                }
                else {
                    s = mid + 1;
                }
            }

            // Right half is sorted
            else {

                if (target > nums[mid] && target <= nums[e]) {
                    s = mid + 1;
                }
                else {
                    e = mid - 1;
                }
            }
        }

        return false;
    }
}