

class Solution {

    // Nearest Smaller to Left
    public int[] getNSL(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return res;
    }

    // Nearest Smaller to Right
    public int[] getNSR(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return res;
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = 1_000_000_007;

        int[] NSL = getNSL(arr, n);
        int[] NSR = getNSR(arr, n);

        long sum = 0;

        for (int i = 0; i < n; i++) {
            long left = i - NSL[i];
            long right = NSR[i] - i;
            sum = (sum + arr[i] * left * right) % MOD;
        }

        return (int) sum;
    }
}
