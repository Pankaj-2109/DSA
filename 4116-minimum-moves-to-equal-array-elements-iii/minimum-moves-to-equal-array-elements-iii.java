class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<n;i++){
            int max=nums[n-1];
            sum+= max-nums[i];


        }
        return sum;
    
        
    }
}