// Last updated: 10/09/2025, 15:08:01
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // dp[j] will hold the min path sum to reach cell (currentRow, j)
        int[] dp = new int[n];
        
        // Initialize first cell
        dp[0] = grid[0][0];
        // Fill in the first row (can only come from the left)
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }
        
        // Process each subsequent row
        for (int i = 1; i < m; i++) {
            // For the first column, you can only come from above
            dp[0] += grid[i][0];
            // For other columns, take min(from left, from above)
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        
        // dp[n-1] now holds the min sum to reach bottom-right
        return dp[n - 1];
    }
}