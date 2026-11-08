class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;

        List<List<Integer>> ans = new ArrayList<>();

        // There are 2^n possible subsets
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> v = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if (((1 << j) & i) != 0) {
                    v.add(nums[j]);
                }
            }

            ans.add(v);
        }

        return ans;
    }
}