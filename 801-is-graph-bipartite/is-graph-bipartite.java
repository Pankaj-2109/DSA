import java.util.*;

class Solution {
    
    private boolean checkBipartiteBFS(int[][] adj, int curr, int[] color, int currColor) {
        color[curr] = currColor;
        
        Queue<Integer> que = new LinkedList<>();
        que.add(curr);
        
        while (!que.isEmpty()) {
            int u = que.poll();
            
            for (int v : adj[u]) {
                if (color[v] == color[u]) {
                    return false;
                } else if (color[v] == -1) {
                    color[v] = 1 - color[u];
                    que.add(v);
                }
            }
        }
        
        return true;
    }
    
    public boolean isBipartite(int[][] adj) {
        
        int V = adj.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);
        
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!checkBipartiteBFS(adj, i, color, 1))
                    return false;
            }
        }
        
        return true;
    }
}
