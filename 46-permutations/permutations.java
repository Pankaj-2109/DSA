import java.util.*;

class Solution {

    List<List<Integer>> result = new ArrayList<>();
    int n;

    void solve(int idx, int[] nums) {

        if (idx == n) {
            List<Integer> temp = new ArrayList<>();

            for (int num : nums) {
                temp.add(num);
            }

            result.add(temp);
            return;
        }

        for (int i = idx; i < n; i++) {

            // Swap
            int temp = nums[i];
            nums[i] = nums[idx];
            nums[idx] = temp;

            solve(idx + 1, nums);

            // Backtracking (undo swap)
            temp = nums[i];
            nums[i] = nums[idx];
            nums[idx] = temp;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;

        solve(0, nums);

        return result;
    }
}