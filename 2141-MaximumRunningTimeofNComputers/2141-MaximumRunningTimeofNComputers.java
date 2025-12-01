// Last updated: 01/12/2025, 23:04:00
1class Solution {
2    public long maxRunTime(int n, int[] batteries) {
3        long total = 0;
4        for (int b : batteries) total += b;
5        long left = 0, right = total / n;
6        while (left < right) {
7            long mid = right - (right - left) / 2;
8            long curr = 0;
9            for (int b : batteries) curr += Math.min(b, mid);
10            if (curr >= mid * n) {
11                left = mid;
12            } else {
13                right = mid - 1;
14            }
15        }
16        return left;
17    }
18}
19