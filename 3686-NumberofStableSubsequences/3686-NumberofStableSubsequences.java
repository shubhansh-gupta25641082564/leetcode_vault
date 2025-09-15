// Last updated: 15/09/2025, 22:00:32
class Solution {
    public int countStableSubsequences(int[] nums) {
        final int MOD = 1_000_000_007;
        long[] dp1 = new long[2];
        long[] dp2 = new long[2];
        for (int v : nums) {
            int p = v & 1;
            long[] new1 = new long[2];
            long[] new2 = new long[2];
            new1[0] = dp1[0];
            new1[1] = dp1[1];
            new2[0] = dp2[0];
            new2[1] = dp2[1];
            new1[p] += 1;
            long sumOther = (dp1[1 - p] + dp2[1 - p]) % MOD;
            new1[p] = (new1[p] + sumOther) % MOD;
            new2[p] = (new2[p] + dp1[p]) % MOD;
            dp1 = new1;
            dp2 = new2;
        }
        long ans = (dp1[0] + dp1[1] + dp2[0] + dp2[1]) % MOD;
        return (int) ans;
    }
}
