class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int s=0;
        int n=arr1.length;
        int m=arr2.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int a=Math.abs(arr1[i]-arr2[j]);
                if(a<=d){
                    s++;
                    break;

                }
            }
        }
        return n-s;
        
    }
}