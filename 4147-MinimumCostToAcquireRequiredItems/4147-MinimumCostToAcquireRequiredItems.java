// Last updated: 01/01/2026, 18:31:14
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long a = 0;
        long b = Math.min(need1, need2);
        long c = Math.max(need1, need2);
        long ans = value(a, cost1, cost2, costBoth, need1, need2);
        long v = value(b, cost1, cost2, costBoth, need1, need2);
        if (v < ans) {
            ans = v;
        }
        v = value(c, cost1, cost2, costBoth, need1, need2);
        if (v < ans) {
            ans = v;
        }
        return ans;
    }
    public static long value(long k, long cost1, long cost2, long costBoth, long need1, long need2) {
        long l1 = need1 - k;
        long l2 = need2 - k;
        if (l1 < 0) {
            l1 = 0;
        }
        if (l2 < 0) {
            l2 = 0;
        }
        return k * costBoth + l1 * cost1 + l2 * cost2;
    }
}