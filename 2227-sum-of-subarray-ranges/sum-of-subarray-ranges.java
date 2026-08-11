class Solution {
     


    // ---------- MINIMUM HELPERS ----------
    public int[] getNSLMin(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return result;
    }

    public int[] getNSRMin(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return result;
    }

    public long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] NSL = getNSLMin(arr, n);
        int[] NSR = getNSRMin(arr, n);

        long sum = 0;

        for (int i = 0; i < n; i++) {
            long d1 = i - NSL[i];
            long d2 = NSR[i] - i;
            sum += (long) arr[i] * d1 * d2;
        }
        return sum;
    }

    // ---------- MAXIMUM HELPERS ----------
    public int[] getNGL(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return result;
    }

    public int[] getNGR(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return result;
    }

    public long sumSubarrayMaxs(int[] arr) {
        int n = arr.length;
        int[] NGL = getNGL(arr, n);
        int[] NGR = getNGR(arr, n);

        long sum = 0;

        for (int i = 0; i < n; i++) {
            long d1 = i - NGL[i];
            long d2 = NGR[i] - i;
            sum += (long) arr[i] * d1 * d2;
        }
        return sum;
    }

    // ---------- FINAL ANSWER ----------
    public long subArrayRanges(int[] nums) {
        long maxSum = sumSubarrayMaxs(nums);
        long minSum = sumSubarrayMins(nums);
        return maxSum - minSum;
    }
}

        
