// Last updated: 16/09/2025, 23:10:45
class Solution {
    public int numTrees(int n) {
        long[] dp = new long[n + 1];
        dp[0] = dp[1] = 1;
        for (int nodes = 2; nodes <= n; nodes++) {
            for (int root = 1; root <= nodes; root++) {
                dp[nodes] += dp[root - 1] * dp[nodes - root];
            }
        }
        return (int) dp[n];
    }
}
