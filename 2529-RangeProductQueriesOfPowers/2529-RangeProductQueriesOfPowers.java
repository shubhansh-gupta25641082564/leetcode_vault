// Last updated: 22/09/2025, 16:13:22
class Solution {
    private static final int MOD = 1_000_000_007;
    public int[] productQueries(int n, int[][] queries) {
        java.util.ArrayList<Integer> exps = new java.util.ArrayList<>();
        for (int i = 0; n > 0; i++, n >>= 1) if ((n & 1) == 1) exps.add(i);
        int m = exps.size();
        long[] pref = new long[m + 1];
        for (int i = 0; i < m; i++) pref[i + 1] = pref[i] + exps.get(i);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            long expSum = pref[r + 1] - pref[l];
            ans[i] = modPow(2, expSum, MOD);
        }
        return ans;
    }
    private int modPow(long a, long e, int mod) {
        long res = 1;
        a %= mod;
        while (e > 0) {
            if ((e & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            e >>= 1;
        }
        return (int) res;
    }
}
