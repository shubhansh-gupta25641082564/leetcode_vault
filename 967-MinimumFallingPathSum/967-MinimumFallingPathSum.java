// Last updated: 10/09/2025, 15:07:37
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] a : dp)
        {
            Arrays.fill(a, -666666);
        }
        for (int col = 0; col <= matrix[0].length; col ++)
        {
            ans = Math.min(ans, minimum(matrix, 0, col, dp));
        }
        return ans;
    }
    public static int minimum(int[][] matrix, int cr, int cc, int[][] dp)
    {
        if (cc < 0 || cc >= matrix[0].length)
        {
            return Integer.MAX_VALUE;
        }
        if (cr == matrix.length - 1)
        {
            return matrix[cr][cc];
        }
        if (dp[cr][cc] != -666666)
        {
            return dp[cr][cc];
        }
        int ld = minimum(matrix, cr + 1, cc - 1, dp);
        int rd = minimum(matrix, cr + 1, cc + 1, dp);
        int d = minimum(matrix, cr + 1, cc, dp);
        return dp[cr][cc] = Math.min(rd, Math.min(ld, d)) + matrix[cr][cc];
    }
}