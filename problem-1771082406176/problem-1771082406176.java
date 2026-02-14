// Last updated: 14/02/2026, 20:50:06
1class Solution {
2    public long rob(int[] nums, int[] colors) {
3        long ans = 0;
4        int i = 0;
5        while (i < nums.length) {
6            int c = colors[i];
7            long t = 0, s = 0;
8            while (i < nums.length && colors[i] == c) {
9                long n = nums[i];
10                long nt = s + n;
11                long ns = Math.max(t, s);
12                t = nt;
13                s = ns;
14                i ++;
15            }
16            ans += Math.max(t, s);
17        }
18        return ans;
19    }
20}