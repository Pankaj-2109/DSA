class Solution {
    public void sortColors(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {
                // Swap 0 to the left
                swap(nums, low, mid);
                low++;
                mid++;

            } else if (nums[mid] == 1) {
                // 1 is already in the correct region
                mid++;

            } else {
                // Swap 2 to the right
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}