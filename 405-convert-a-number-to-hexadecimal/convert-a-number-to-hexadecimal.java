class Solution {
    public String toHex(int n) {
        char[] h = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
        };

        String result = "";

        if (n == 0) {
            return "0";
        }

        long num;

        if (n < 0) {
            num = (1L << 32) + n;
        } else {
            num = n;
        }

        while (num != 0) {
            int rem = (int)(num % 16);
            result = h[rem] + result;
            num = num / 16;
        }

        return result;
    }
}