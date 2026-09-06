import java.util.*;

class Solution {

    // Using Kahn's Algorithm
    private int[] topologicalSortCheck(
            Map<Integer, List<Integer>> adj,
            int n,
            int[] indegree) {

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        int[] result = new int[n];
        int index = 0;

        // Add all nodes with indegree 0
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                result[index++] = i;
                count++;
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();

            // Process all neighbors
            for (int v : adj.getOrDefault(u, new ArrayList<>())) {

                indegree[v]--;

                if (indegree[v] == 0) {
                    result[index++] = v;
                    count++;
                    queue.offer(v);
                }
            }
        }

        // Cycle exists
        if (count != n) {
            return new int[0];
        }

        return result;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> adj = new HashMap<>();

        int[] indegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];

            // b ---> a
            adj.computeIfAbsent(b, k -> new ArrayList<>()).add(a);

            // Edge is going into 'a'
            indegree[a]++;
        }

        // If cycle is present, return empty array
        return topologicalSortCheck(adj, numCourses, indegree);
    }
}
