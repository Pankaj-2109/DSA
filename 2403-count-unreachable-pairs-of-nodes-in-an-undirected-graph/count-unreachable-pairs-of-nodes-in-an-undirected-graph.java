import java.util.HashMap;
import java.util.Map;

class Solution {
    private int[] parent;
    private int[] rank;

    private int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]); // Path compression
    }

    private void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent) {
            return;
        }

        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        } else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }

    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            union(u, v);
        }

        // Count size of each connected component
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            map.put(root, map.getOrDefault(root, 0) + 1);
        }

        long result = 0;
        long remainingNodes = n;

        for (int size : map.values()) {
            result += (long) size * (remainingNodes - size);
            remainingNodes -= size;
        }

        return result;
    }
}