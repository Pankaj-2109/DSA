class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        
        int n=pairs.length;
        int[] t=new int[n];
        Arrays.fill(t,1);

        int max=1;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(pairs[j][1] < pairs[i][0]){
                    t[i]=Math.max(t[i],t[j]+1);
                    max=Math.max(max,t[i]);
                }
            }
        }
        return max;
        
    }
}


