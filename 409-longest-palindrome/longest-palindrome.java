class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        
        int result = 0;
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        boolean takeCentralChar = false;
        for(int count : map.values()) {
            if(count % 2 == 0) {
                result += count;
            } else {
                result += count - 1;
                takeCentralChar = true;
            }
        }
        
        if(takeCentralChar) {
            result++;
        }
        
        return result;
    }
}