// Last updated: 17/09/2025, 23:05:55
class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        // use long to be safe for intermediate sums; final answer fits in 32-bit per problem statement
        long[] dp = new long[m + 1];
        dp[0] = 1; // one way to form empty t

        for (int i = 1; i <= n; i++) {
            // iterate j from m down to 1 to avoid overwriting dp[j-1] needed for this row
            for (int j = m; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return (int) dp[m];
    }
}
