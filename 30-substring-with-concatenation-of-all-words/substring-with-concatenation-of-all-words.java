
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();

        int n = s.length();
        int m = words.length;
        int len = words[0].length();

        int totalLen = m * len;

        if (n < totalLen) {
            return ans;
        }

        // Store frequency of each word
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Try each possible offset
        for (int i = 0; i < len; i++) {

            int left = i;
            int count = 0;

            Map<String, Integer> seen = new HashMap<>();

            for (int right = i; right + len <= n; right += len) {

                String word = s.substring(right, right + len);

                // Word is not present in words
                if (!map.containsKey(word)) {
                    seen.clear();
                    count = 0;
                    left = right + len;
                    continue;
                }

                seen.put(word, seen.getOrDefault(word, 0) + 1);
                count++;

                // Remove extra occurrences
                while (seen.get(word) > map.get(word)) {

                    String leftWord = s.substring(left, left + len);

                    seen.put(leftWord, seen.get(leftWord) - 1);

                    left += len;
                    count--;
                }

                // All words matched
                if (count == m) {
                    ans.add(left);

                    String leftWord = s.substring(left, left + len);

                    seen.put(leftWord, seen.get(leftWord) - 1);

                    left += len;
                    count--;
                }
            }
        }

        return ans;
    }
}
