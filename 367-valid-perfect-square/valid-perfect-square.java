class Solution {
    public boolean isPerfectSquare(int num) {
        int l=0;
        int r=num/2;
        while(l<=r){
            int mid=l+(r-l)/2;
            long s = (long) mid * mid;
            if(num==1 ){
                return true;
            }
            if( s>num ){
                r=mid-1;
            }
            else if(s<num){
                l=mid+1;

            }
            else{
                return true;
            }
        }
        return false;
        
    }
}