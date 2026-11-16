
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currRow = 0;
        int direction = 1;

        for (int i = 0; i < s.length(); i++) {
            rows[currRow].append(s.charAt(i));

            if (currRow == 0) {
                direction = 1;
            } else if (currRow == numRows - 1) {
                direction = -1;
            }

            currRow += direction;
        }

        StringBuilder result = new StringBuilder();

        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
