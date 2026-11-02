class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long totalFlowersNeeded = (long) m * k;
        if (totalFlowersNeeded > bloomDay.length) {
            return -1;
        }

        int[] range = findRange(bloomDay);
        int start = range[0];
        int end = range[1];
        int answer = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isPossible(mid, k, m, bloomDay)) {
                answer = mid;
                end = mid - 1; // Try to find a smaller valid day
            } else {
                start = mid + 1; // Need more days
            }
        }

        return answer;
    }

    private int[] findRange(int[] bloomDay) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            min = Math.min(min, day);
            max = Math.max(max, day);
        }

        return new int[] { min, max };
    }

    private boolean isPossible(int minDay, int k, int m, int[] bloomDay) {
        int totalBouquets = 0;
        int count = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= minDay) {
                count++;
            } else {
                count = 0;
            }

            if (count == k) {
                totalBouquets++;
                count = 0;
            }

            if (totalBouquets >= m) {
                return true;
            }
        }

        return totalBouquets >= m;
    }
}