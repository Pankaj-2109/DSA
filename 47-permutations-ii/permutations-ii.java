class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private int n;

    public List<List<Integer>> permuteUnique(int[] nums) {
        n = nums.length;

        solve(0, nums);

        return result;
    }

    private void solve(int idx, int[] nums) {
        if (idx == n) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }

        Set<Integer> uniqueSet = new HashSet<>();
        for (int i = idx; i < n; i++) {

            if (uniqueSet.contains(nums[i])) {
                continue;
            }

            uniqueSet.add(nums[i]);

            swap(nums, i, idx);

            solve(idx + 1, nums);

            swap(nums, i, idx);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}