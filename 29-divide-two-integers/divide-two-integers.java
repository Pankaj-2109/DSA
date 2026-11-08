
class Solution {
    public int divide(int dividend, int divisor) {

        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine sign of result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert to long to avoid integer overflow
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long ans = 0;

        // Subtract largest possible multiples using bit shifting
        while (a >= b) {

            long temp = b;
            long count = 1;

            while (a >= (temp << 1)) {
                temp <<= 1;
                count <<= 1;
            }

            a -= temp;
            ans += count;
        }

        // Apply sign
        if (negative) {
            ans = -ans;
        }

        return (int) ans;
    }
}
