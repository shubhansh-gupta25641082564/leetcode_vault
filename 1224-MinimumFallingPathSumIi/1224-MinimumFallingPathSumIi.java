// Last updated: 10/09/2025, 15:07:34
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] a : dp)
        {
            Arrays.fill(a, -666666);
        }
        for (int col = 0; col < matrix[0].length; col ++)
        {
            ans = Math.min(ans, minimum(matrix, 0, col, dp));
        }
        return ans;
    }
    public static int minimum(int[][] matrix, int cr, int cc, int[][] dp)
    {
        if (cr == matrix.length - 1)
        {
            return matrix[cr][cc];
        }
        if (dp[cr][cc] != -666666)
        {
            return dp[cr][cc];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i ++)
        {
            if (i == cc)
            {
                continue;
            }
            ans = Math.min(ans, minimum(matrix, cr + 1, i, dp));
        }
        return dp[cr][cc] = ans + matrix[cr][cc];
    }
}