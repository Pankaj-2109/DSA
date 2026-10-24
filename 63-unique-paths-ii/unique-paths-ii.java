

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {


        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return uniquePaths(obstacleGrid, m, n);
    }
    public int uniquePaths(int[][] obstacleGrid,int m, int n) {
        int dp[][] = new int[m+1][n+1];

        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0 || obstacleGrid[i-1][j-1]==1){
                    dp[i][j] = 0;
                }else if(i==1 && j==1){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1]; //recur(m-1,n, dp) + recur(m,n-1, dp);
                }
            }
        }
        return dp[m][n]; //recur(m,n, dp);
    }
}