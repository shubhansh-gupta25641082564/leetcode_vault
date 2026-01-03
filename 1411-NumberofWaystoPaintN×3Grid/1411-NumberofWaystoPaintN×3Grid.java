// Last updated: 03/01/2026, 08:30:57
1class Solution {
2    public int numOfWays(int n) {
3        long mod = 1000000007L;
4        long a = 6;
5        long b = 6;
6
7        for (int i = 1; i < n; i++) {
8            long na = (3 * a + 2 * b) % mod;
9            long nb = (2 * a + 2 * b) % mod;
10            a = na;
11            b = nb;
12        }
13
14        return (int) ((a + b) % mod);
15    }
16}
17