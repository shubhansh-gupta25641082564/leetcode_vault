// Last updated: 20/09/2025, 00:31:13
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        // If k is large enough, it's equivalent to unlimited transactions.
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
            }
            return profit;
        }

        // dp[i][j] = max profit using at most i transactions up to day j (0-indexed days)
        // We only need previous transaction row, so keep 1D arrays.
        int[] prev = new int[n];
        int[] cur = new int[n];

        for (int i = 1; i <= k; i++) {
            int maxDiff = prev[0] - prices[0]; // max of (prev[t] - prices[t]) for t < current day
            cur[0] = 0; // with 0..0 days, profit is 0
            for (int j = 1; j < n; j++) {
                // either do nothing on day j or sell on day j having bought earlier at best position
                cur[j] = Math.max(cur[j - 1], prices[j] + maxDiff);
                // update maxDiff to consider prev[j] - prices[j] for future days
                maxDiff = Math.max(maxDiff, prev[j] - prices[j]);
            }
            // swap prev and cur for next transaction count
            int[] tmp = prev;
            prev = cur;
            cur = tmp;
        }

        return prev[n - 1];
    }
}
