// Last updated: 05/10/2025, 00:08:21
class Solution {
    public int possibleStringCount(String word, int k) {
        final int MOD = 1_000_000_007;
        int n = word.length();
        // 1) Collect run‐lengths
        List<Integer> groups = new ArrayList<>();
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                cnt++;
            } else {
                groups.add(cnt);
                cnt = 1;
            }
        }
        groups.add(cnt);
        int m = groups.size();

        // 2) Compute total ways = ∏ groupLen
        long total = 1;
        for (int g : groups) {
            total = total * g % MOD;
        }

        // 3) If minimal possible length (m) ≥ k, all of them are valid
        if (m >= k) {
            return (int) total;
        }

        // 4) DP to count “invalid” ways of getting length < k
        // dp[j] = #ways after some runs to have total length exactly j
        int[] dp = new int[k];
        dp[0] = 1;  // zero runs → length 0

        // Process at most the first k runs (after that minimal length > k)
        for (int i = 0; i < Math.min(m, k); i++) {
            int c = groups.get(i);
            int[] next = new int[k];
            long window = 0;
            // Build next[j] = sum of dp[j - q] for q = 1..c
            // i.e. a sliding window over dp[0..k-2]
            for (int j = 1; j < k; j++) {
                window = (window + dp[j - 1]) % MOD;
                if (j - 1 - c >= 0) {
                    window = (window - dp[j - 1 - c] + MOD) % MOD;
                }
                next[j] = (int) window;
            }
            dp = next;
        }

        // Sum up dp[0..k-1] to get #ways with length < k
        long invalid = 0;
        for (int j = 0; j < k; j++) {
            invalid = (invalid + dp[j]) % MOD;
        }

        // Subtract from total
        long ans = (total - invalid + MOD) % MOD;
        return (int) ans;
    }
}
