
import java.util.Arrays;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);

        int count = 0;

        for (int x : arr1) {
            int idx = Arrays.binarySearch(arr2, x);

            if (idx < 0) {
                idx = -idx - 1;
            }

            boolean valid = true;

            // Check the closest element on the right
            if (idx < arr2.length && arr2[idx] - x <= d) {
                valid = false;
            }

            // Check the closest element on the left
            if (idx > 0 && x - arr2[idx - 1] <= d) {
                valid = false;
            }

            if (valid) {
                count++;
            }
        }

        return count;
    }
}
