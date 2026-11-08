class Solution {
    class DSU {
        int[] parent;
        int[] rank;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int i) {
            if (parent[i] == i)
                return i;
            return parent[i] = find(parent[i]);
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                if (rank[rootI] < rank[rootJ]) {
                    parent[rootI] = rootJ;
                    rank[rootJ] += rank[rootI];
                } else {
                    parent[rootJ] = rootI;
                    rank[rootI] += rank[rootJ];
                }
            }
        }
    }

    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        DSU dsu = new DSU(m + n);
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        // First pass: Count servers in each row and column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        // Second pass: Union row and column for each server
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dsu.union(i, j + m);
                }
            }
        }

        int communicatingServers = 0;

        // Third pass: Count servers that have a peer in their row or column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (rowCount[i] > 1 || colCount[j] > 1) {
                        communicatingServers++;
                    }
                }
            }
        }

        return communicatingServers;
    }
}