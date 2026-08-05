class Solution {
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
        current.remove(current.size() - 1);

        // exclude current number
        while(index+1 < nums.length && nums[index]==nums[index+1]  ){
            index++;
        }
        
        List<List<Integer>> exclude = helper(current, index + 1, nums);

        // merge results
        include.addAll(exclude);
        return include;
    }     
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         Arrays.sort(nums);
         return helper(new ArrayList<>(), 0, nums);
        
    }
}