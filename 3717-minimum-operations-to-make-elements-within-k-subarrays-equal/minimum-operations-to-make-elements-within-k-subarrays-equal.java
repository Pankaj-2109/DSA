import java.util.*;

class Solution {
    int m;
    long[] cnt, sum;

    void update(int i, long c, long s) {
        for (; i <= m; i += i & -i) { cnt[i] += c; sum[i] += s; }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        // coordinate compression
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int[] vals = new int[n];
        m = 0;
        for (int v : sorted) if (m == 0 || vals[m - 1] != v) vals[m++] = v;
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) rank[i] = Arrays.binarySearch(vals, 0, m, nums[i]) + 1;

        cnt = new long[m + 1];
        sum = new long[m + 1];
        int LOG = Integer.highestOneBit(m);

        // cost[i] = min ops to make nums[i..i+x-1] all equal
        long[] cost = new long[n - x + 1];
        long total = 0;
        int kth = (x + 1) / 2;

        for (int i = 0; i < n; i++) {
            update(rank[i], 1, nums[i]);
            total += nums[i];
            if (i >= x) {
                update(rank[i - x], -1, -nums[i - x]);
                total -= nums[i - x];
            }
            if (i >= x - 1) {
                // find kth smallest via Fenwick descent
                int pos = 0, rem = kth;
                for (int pw = LOG; pw > 0; pw >>= 1) {
                    if (pos + pw <= m && cnt[pos + pw] < rem) {
                        pos += pw;
                        rem -= cnt[pos];
                    }
                }
                int idx = pos + 1;
                long med = vals[idx - 1];

                // prefix count / sum of elements with rank <= idx
                long c = 0, s = 0;
                for (int j = idx; j > 0; j -= j & -j) { c += cnt[j]; s += sum[j]; }

                cost[i - x + 1] = med * c - s + (total - s) - med * (x - c);
            }
        }

        // DP over number of chosen windows
        final long INF = Long.MAX_VALUE / 4;
        long[] prev = new long[n + 1];          // j = 0 -> all zeros
        for (int j = 1; j <= k; j++) {
            long[] cur = new long[n + 1];
            Arrays.fill(cur, INF);
            for (int i = x; i <= n; i++) {
                cur[i] = Math.min(cur[i - 1], prev[i - x] + cost[i - x]);
            }
            prev = cur;
        }
        return prev[n];
    }
}