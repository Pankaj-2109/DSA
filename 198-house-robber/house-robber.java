class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        
        if(n==1){
            return nums[0];
        }
        int p1=nums[0];
        int p2=0;
        int ans=0;
        for(int i=2;i<n+1;i++){
            int p= nums[i-1]+p2;
            int np=p1;
            ans=Math.max(p,np);
            
            p2=p1;
            p1=ans;
        }
        return ans;
        
    }
    
}