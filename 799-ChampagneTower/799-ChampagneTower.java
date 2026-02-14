// Last updated: 14/02/2026, 21:09:28
1class Solution {
2    public double champagneTower(int poured, int query_row, int query_glass) {
3        // Only need to simulate up to query_row; +2 prevents bounds issues on r+1 and c+1
4        double[][] dp = new double[query_row + 2][query_row + 2];
5        dp[0][0] = poured;
6
7        for (int r = 0; r <= query_row; r++) {
8            for (int c = 0; c <= r; c++) {
9                double overflow = Math.max(0.0, dp[r][c] - 1.0);
10                if (overflow > 0) {
11                    dp[r + 1][c] += overflow / 2.0;
12                    dp[r + 1][c + 1] += overflow / 2.0;
13                }
14            }
15        }
16
17        return Math.min(1.0, dp[query_row][query_glass]);
18    }
19}
20