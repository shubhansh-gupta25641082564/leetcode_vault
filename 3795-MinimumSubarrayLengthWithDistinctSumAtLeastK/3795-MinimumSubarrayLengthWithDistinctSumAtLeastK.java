// Last updated: 04/01/2026, 09:48:09
1class Solution {
2    static final int MOD = 1_000_000_007;
3
4    public int numberOfRoutes(String[] grid, int d) {
5        int n = grid.length;
6        int m = grid[0].length();
7        char[][] g = new char[n][];
8        for (int i = 0; i < n; i++) g[i] = grid[i].toCharArray();
9
10        long dd = 1L * d * d;
11        int du = (int) Math.floor(Math.sqrt(dd - 1));
12
13        long[] dp0 = new long[m];
14        long[] dp1 = new long[m];
15
16        for (int c = 0; c < m; c++) {
17            if (g[n - 1][c] == '.') dp0[c] = 1;
18        }
19
20        long[] prefix = new long[m + 1];
21
22        for (int r = n - 1; r >= 0; r--) {
23            prefix[0] = 0;
24            for (int c = 0; c < m; c++) {
25                long v = prefix[c] + dp0[c];
26                prefix[c + 1] = v >= MOD ? v - MOD : v;
27            }
28
29            for (int c = 0; c < m; c++) {
30                if (g[r][c] == '#') {
31                    dp1[c] = 0;
32                    dp0[c] = 0;
33                    continue;
34                }
35                int l = c - d;
36                if (l < 0) l = 0;
37                int rr = c + d;
38                if (rr >= m) rr = m - 1;
39                long sum = prefix[rr + 1] - prefix[l];
40                sum %= MOD;
41                if (sum < 0) sum += MOD;
42                sum -= dp0[c];
43                sum %= MOD;
44                if (sum < 0) sum += MOD;
45                dp1[c] = sum;
46            }
47
48            if (r == 0) break;
49
50            prefix[0] = 0;
51            for (int c = 0; c < m; c++) {
52                long t = dp0[c] + dp1[c];
53                if (t >= MOD) t -= MOD;
54                long v = prefix[c] + t;
55                prefix[c + 1] = v >= MOD ? v - MOD : v;
56            }
57
58            long[] nextDp0 = new long[m];
59            for (int c = 0; c < m; c++) {
60                if (g[r - 1][c] == '#') continue;
61                int l = c - du;
62                if (l < 0) l = 0;
63                int rr = c + du;
64                if (rr >= m) rr = m - 1;
65                long sum = prefix[rr + 1] - prefix[l];
66                sum %= MOD;
67                if (sum < 0) sum += MOD;
68                nextDp0[c] = sum;
69            }
70
71            dp0 = nextDp0;
72            dp1 = new long[m];
73        }
74
75        long ans = 0;
76        for (int c = 0; c < m; c++) {
77            ans += dp0[c] + dp1[c];
78            ans %= MOD;
79        }
80        return (int) ans;
81    }
82}
83