import java.util.*;

class Solution {

    class Pair {
        int dist;
        int x;
        int y;

        Pair(int dist, int x, int y) {
            this.dist = dist;
            this.x = x;
            this.y = y;
        }
    }

    int[][] directions = {
        {1, 1}, {0, 1}, {1, 0}, {0, -1},
        {-1, 0}, {-1, -1}, {1, -1}, {-1, 1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if (m == 0 || n == 0 || grid[0][0] != 0)
            return -1;

        int[][] result = new int[m][n];

        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> a.dist - b.dist);

        pq.offer(new Pair(0, 0, 0));
        result[0][0] = 0;

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int d = curr.dist;
            int x = curr.x;
            int y = curr.y;

            for (int[] dir : directions) {

                int nx = x + dir[0];
                int ny = y + dir[1];
                int dist = 1;

                if (isSafe(nx, ny, m, n)
                        && grid[nx][ny] == 0
                        && d + dist < result[nx][ny]) {

                    pq.offer(new Pair(d + dist, nx, ny));

                    grid[nx][ny] = 1;
                    result[nx][ny] = d + dist;
                }
            }
        }

        if (result[m - 1][n - 1] == Integer.MAX_VALUE)
            return -1;

        return result[m - 1][n - 1] + 1;
    }

    private boolean isSafe(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}