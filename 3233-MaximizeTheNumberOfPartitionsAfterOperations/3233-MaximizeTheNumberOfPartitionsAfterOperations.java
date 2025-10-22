// Last updated: 22/10/2025, 19:22:59
class Solution {
    String t;
    int K;
    java.util.Map<Long, Integer> memo;
    public int maxPartitionsAfterOperations(String s, int k) {
        t = s;
        K = k;
        memo = new java.util.HashMap<>();
        return dfs(0, 0, 1);
    }
    int dfs(int i, int mask, int canChange) {
        if (i >= t.length()) return 1;
        long key = (((long) i) << 32) | (((long) mask) << 1) | canChange;
        Integer cached = memo.get(key);
        if (cached != null) return cached;
        int bit = 1 << (t.charAt(i) - 'a');
        int m = mask | bit;
        int ans = (Integer.bitCount(m) > K) ? dfs(i + 1, bit, canChange) + 1 : dfs(i + 1, m, canChange);
        if (canChange == 1) {
            for (int c = 0; c < 26; ++c) {
                int m2 = mask | (1 << c);
                if (Integer.bitCount(m2) > K) {
                    ans = Math.max(ans, dfs(i + 1, 1 << c, 0) + 1);
                } else {
                    ans = Math.max(ans, dfs(i + 1, m2, 0));
                }
            }
        }
        memo.put(key, ans);
        return ans;
    }
}
