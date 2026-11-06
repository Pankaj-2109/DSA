import java.util.HashMap;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    
    private int atMostK(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int start = 0;
        int end = 0;
        int count = 0;
        int n = nums.length;
        
        while (end < n) {
            // Expansion phase
            freqMap.put(nums[end], freqMap.getOrDefault(nums[end], 0) + 1);
            
            // Shrinking phase when unique elements exceed k
            while (freqMap.size() > k) {
                freqMap.put(nums[start], freqMap.get(nums[start]) - 1);
                if (freqMap.get(nums[start]) == 0) {
                    freqMap.remove(nums[start]);
                }
                start++;
            }
            
            // Count subarrays ending at 'end' with at most k distinct integers
            count += (end - start + 1);
            end++;
        }
        
        return count;
    }
}