class Solution {
    List<List<Integer>> result = new ArrayList<>();

    void solve(int start, int n, int k, List<Integer> temp) {

        if (k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (start > n) {
            return;
        }

        // Include the current number
        temp.add(start);
        solve(start + 1, n, k - 1, temp);

        // Backtrack
        temp.remove(temp.size() - 1);

        // Exclude the current number
        solve(start + 1, n, k, temp);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<>();

        solve(1, n, k, temp);

        return result;
    }
}