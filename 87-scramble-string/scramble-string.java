class Solution {

    HashMap<String, Boolean> mp = new HashMap<>();

    public boolean solve(String s1, String s2) {

        if (s1.equals(s2))
            return true;

        if (s1.length() != s2.length())
            return false;

        String key = s1 + "_" + s2;

        if (mp.containsKey(key))
            return mp.get(key);

        boolean result = false;
        int n = s1.length();

        for (int i = 1; i < n; i++) {

            // Swapped
            boolean swapped =
                solve(s1.substring(0, i), s2.substring(n - i)) &&
                solve(s1.substring(i), s2.substring(0, n - i));

            if (swapped) {
                result = true;
                break;
            }

            // Not swapped
            boolean notSwapped =
                solve(s1.substring(0, i), s2.substring(0, i)) &&
                solve(s1.substring(i), s2.substring(i));

            if (notSwapped) {
                result = true;
                break;
            }
        }

        mp.put(key, result);
        return result;
    }

    public boolean isScramble(String s1, String s2) {
        mp.clear();
        return solve(s1, s2);
    }
}