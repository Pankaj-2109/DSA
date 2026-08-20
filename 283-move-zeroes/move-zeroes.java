class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;

        // Place all non-zero elements at the beginning
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        // Fill remaining positions with 0
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }
}