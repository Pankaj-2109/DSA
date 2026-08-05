class Solution {

    static void solve(int[] candidates, int target, int index,
                      List<List<Integer>> ans,
                      List<Integer> output,
                      int count, int k) {

        if (target == 0 && count == k) {
            ans.add(new ArrayList<>(output));
            return;
        }

        if (target < 0 || count > k || index >= candidates.length) {
            return;
        }

        // Include current element
        output.add(candidates[index]);
        solve(candidates,
              target - candidates[index],
              index + 1,
              ans,
              output,
              count + 1,
              k);
        output.remove(output.size() - 1);

        // Exclude current element
        solve(candidates,
              target,
              index + 1,
              ans,
              output,
              count,
              k);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        int[] candidates = {1,2,3,4,5,6,7,8,9};

        solve(candidates, n, 0, ans, output, 0, k);

        return ans;
    }
}