
class Solution {
    public int countPrimes(int n) {

        if (n <= 2) return 0;

        boolean[] isPrime = new boolean[n];

        for (int i = 3; i < n; i += 2) {
            isPrime[i] = true;
        }

        int count = 1; // Prime number 2

        for (int i = 3; i * i < n; i += 2) {

            if (isPrime[i]) {

                for (int j = i * i; j < n; j += 2 * i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 3; i < n; i += 2) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }
}
