
class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();

        // If either number is zero
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] result = new int[n + m];

        // Multiply digit by digit
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                int mul = (num1.charAt(i) - '0') *
                          (num2.charAt(j) - '0');

                int sum = mul + result[i + j + 1];

                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }

        // Convert result array to string
        StringBuilder sb = new StringBuilder();

        int i = 0;

        // Skip leading zeros
        while (i < result.length && result[i] == 0) {
            i++;
        }

        while (i < result.length) {
            sb.append(result[i]);
            i++;
        }

        return sb.toString();
    }
}
