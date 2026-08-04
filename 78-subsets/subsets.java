

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return helper(new ArrayList<>(), 0, nums);
    }

    private List<List<Integer>> helper(List<Integer> current, int index, int[] nums) {
        // base case
        if (index == nums.length) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>(current));
            return result;
        }

        // recursive case
        int num = nums[index];

        // include current number
        current.add(num);
        List<List<Integer>> include = helper(current, index + 1, nums);

        // exclude current number
        current.remove(current.size() - 1);
        List<List<Integer>> exclude = helper(current, index + 1, nums);

        // merge results
        include.addAll(exclude);
        return include;
    }

    
}
