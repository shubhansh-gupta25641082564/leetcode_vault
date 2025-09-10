// Last updated: 10/09/2025, 15:08:02
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // dp[j] = number of ways to reach cell in current row at column j
        int[] dp = new int[n];
        
        // Starting position: if there's no obstacle at (0,0), there's 1 way to be there.
        dp[0] = (obstacleGrid[0][0] == 0) ? 1 : 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    // Obstacle: no ways to reach here
                    dp[j] = 0;
                } else if (j > 0) {
                    // Free cell: ways to reach = from top (dp[j] before update)
                    //                         + from left (dp[j-1])
                    dp[j] += dp[j - 1];
                }
                // else j==0 and no obstacle: dp[0] stays as is (only from above)
            }
        }
        
        return dp[n - 1];
    }
}