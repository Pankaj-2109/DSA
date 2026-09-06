import java.util.*;

class Solution {

    boolean topologicalSortCheck(
            Map<Integer, List<Integer>> adj,
            int n,
            int[] indegree) {

        Queue<Integer> queue = new LinkedList<>();

        int count = 0;

        // Add all nodes with indegree 0
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                count++;
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {

            int u = queue.poll();

            // Traverse all neighbors
            if (adj.containsKey(u)) {
                for (int v : adj.get(u)) {

                    indegree[v]--;

                    if (indegree[v] == 0) {
                        count++;
                        queue.offer(v);
                    }
                }
            }
        }

        // If we visited all courses, no cycle exists
        return count == n;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> adj = new HashMap<>();

        int[] indegree = new int[numCourses];

        // Build graph
        for (int[] prerequisite : prerequisites) {

            int a = prerequisite[0];
            int b = prerequisite[1];

            // b ---> a
            adj.computeIfAbsent(b, k -> new ArrayList<>()).add(a);

            // Edge is going into 'a'
            indegree[a]++;
        }

        // Check whether graph contains a cycle
        return topologicalSortCheck(adj, numCourses, indegree);
    }
}
