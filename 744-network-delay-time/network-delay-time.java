import java.util.*;

class Solution {

    static class Pair {
        int dist;
        int node;

        Pair(int d, int n) {
            dist = d;
            node = n;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        // Adjacency list (Directed graph)
        HashMap<Integer, ArrayList<Pair>> adj = new HashMap<>();
        for (int i = 1; i <= n; i++)
            adj.put(i, new ArrayList<>());

        // Build graph (u -> v)
        for (int[] e : times) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adj.get(u).add(new Pair(w, v));
        }

        // Min Heap (distance, node)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;
        pq.add(new Pair(0, k));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int d = cur.dist;
            int node = cur.node;

            for (Pair it : adj.get(node)) {
                int adjNode = it.node;
                int wt = it.dist;

                if (d + wt < dist[adjNode]) {
                    dist[adjNode] = d + wt;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        // Find maximum time to reach all nodes
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}