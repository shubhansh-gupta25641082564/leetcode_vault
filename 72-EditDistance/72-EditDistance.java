// Last updated: 10/09/2025, 15:07:51
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        // dp[i][j] = min operations to convert word1[0..i-1] to word2[0..j-1]
        int[][] dp = new int[m+1][n+1];

        // Base cases:
        // converting empty word1 to word2[0..j-1] needs j inserts
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        // converting word1[0..i-1] to empty word2 needs i deletes
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    // characters match, no new op
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    // consider replace, insert, delete
                    int replaceCost = dp[i-1][j-1] + 1;
                    int insertCost  = dp[i][j-1]   + 1;
                    int deleteCost  = dp[i-1][j]   + 1;
                    dp[i][j] = Math.min(replaceCost,
                                Math.min(insertCost, deleteCost));
                }
            }
        }

        return dp[m][n];
    }
}