// Last updated: 22/09/2025, 16:13:20
class Solution {
    private static final int MOD = 1_000_000_007;
    public int numberOfWays(int n, int x) {
        int max = 1;
        while (Math.pow(max + 1, x) <= n) max++;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int num = 1; num <= max; num++) {
            int val = 1;
            for (int i = 0; i < x; i++) val *= num;
            for (int s = n; s >= val; s--) {
                dp[s] += dp[s - val];
                if (dp[s] >= MOD) dp[s] -= MOD;
            }
        }
        return dp[n];
    }
}

