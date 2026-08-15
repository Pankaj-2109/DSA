class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int sum = 0;
        int ans = 0;

        for (int num : nums) {
            // Odd -> 1, Even -> 0
            if (num % 2 != 0) {
                sum++;
            }

            // Need a previous prefix with sum = sum - k
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}