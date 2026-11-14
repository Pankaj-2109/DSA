class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] temp = s.split(" ");

        if (temp.length != pattern.length()) {
            return false;
        }

        HashMap<String, Character> mp = new HashMap<>();
        HashSet<Character> used = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i);
            String word = temp[i];

            if (!mp.containsKey(word) && !used.contains(ch)) {
                mp.put(word, ch);
                used.add(ch);
            }
            else if (!mp.containsKey(word) || mp.get(word) != ch) {
                return false;
            }
        }

        return true;
    }
}