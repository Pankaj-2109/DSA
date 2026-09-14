class Solution {

    public int ladderLength(String beginWord, String endWord,
                            List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {

            int lvlsize = queue.size();

            for (int i = 0; i < lvlsize; i++) {

                String currWord = queue.poll();

                if (currWord.equals(endWord)) {
                    return level;
                }

                // Separate function
                List<String> nextWords = getNextWords(currWord, set);

                for (String word : nextWords) {
                    queue.offer(word);
                    set.remove(word);
                }
            }

            level++;
        }

        return 0;
    }

    // Generates all words that differ by exactly one character
    private List<String> getNextWords(String word, Set<String> set) {

        List<String> result = new ArrayList<>();

        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            char original = chars[i];

            for (char ch = 'a'; ch <= 'z'; ch++) {

                if (ch == original) {
                    continue;
                }

                chars[i] = ch;

                String newWord = new String(chars);

                if (set.contains(newWord)) {
                    result.add(newWord);
                }
            }

            chars[i] = original;
        }

        return result;
    }
}
