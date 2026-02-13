// Last updated: 13/02/2026, 21:26:45
1class Solution {
2    public long maximumTripletValue(int[] nums) {
3        long ans = 0;
4        long maxNum = 0;   // best nums[i] so far
5        long maxDiff = 0;  // best (nums[i] - nums[j]) so far for some i < j
6
7        for (int x : nums) {
8            // x acts as nums[k]
9            ans = Math.max(ans, maxDiff * (long) x);
10
11            // x acts as nums[j]
12            maxDiff = Math.max(maxDiff, maxNum - (long) x);
13
14            // x acts as nums[i]
15            maxNum = Math.max(maxNum, (long) x);
16        }
17        return ans;
18    }
19}