class Solution {
    public boolean checkString(String s) {
        int n=s.length();
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)=='b'){
                if(s.charAt(i)==s.charAt(i+1)){
                    continue;
                }
                return false;
            }
        }
        return true;
        
    }
}