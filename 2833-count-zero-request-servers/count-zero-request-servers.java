import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length;
        
        // 1. Sort logs based on time (logs[i][1])
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        
        // 2. Sort queries while keeping track of their original indices
        int[][] sortedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i; // original index
        }
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] ans = new int[m];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int left = 0;
        int right = 0;
        int numLogs = logs.length;
        
        // 3. Process each query using a sliding window on logs
        for (int i = 0; i < m; i++) {
            int qTime = sortedQueries[i][0];
            int origIdx = sortedQueries[i][1];
            
            int startTime = qTime - x;
            int endTime = qTime;
            
            // Expand the right pointer while log time <= endTime
            while (right < numLogs && logs[right][1] <= endTime) {
                int serverId = logs[right][0];
                map.put(serverId, map.getOrDefault(serverId, 0) + 1);
                right++;
            }
            
            // Shrink the left pointer while log time < startTime
            while (left < numLogs && logs[left][1] < startTime) {
                int serverId = logs[left][0];
                map.put(serverId, map.get(serverId) - 1);
                if (map.get(serverId) == 0) {
                    map.remove(serverId);
                }
                left++;
            }
            
            // Total servers - servers with at least one request = servers with zero requests
            ans[origIdx] = n - map.size();
        }
        
        return ans;
    }
}