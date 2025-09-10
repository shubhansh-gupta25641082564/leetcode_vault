// Last updated: 10/09/2025, 15:07:26
class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1000000007;
        long[] dp = new long[n + 1];
        long[] pref = new long[n + 1];
        dp[1] = 1;
        pref[0] = 0;
        pref[1] = 1;
        for (int i = 2; i <= n; i++) {
            int jmin = i - forget + 1;
            int jmax = i - delay;
            if (jmax >= 1) {
                if (jmin < 1) jmin = 1;
                long sum = (pref[jmax] - pref[jmin - 1]) % MOD;
                if (sum < 0) sum += MOD;
                dp[i] = sum;
            } else {
                dp[i] = 0;
            }
            pref[i] = (pref[i - 1] + dp[i]) % MOD;
        }
        int cutoff = n - forget;
        long ans = pref[n] - (cutoff >= 0 ? pref[cutoff] : 0);
        ans %= MOD;
        if (ans < 0) ans += MOD;
        return (int) ans;
    }
}
