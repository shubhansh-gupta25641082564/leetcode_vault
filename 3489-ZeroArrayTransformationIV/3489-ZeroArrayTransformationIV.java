// Last updated: 27/01/2026, 18:39:38
1class Solution {
2    public int minZeroArray(int[] nums, int[][] queries) {
3        int m = queries.length;
4        int left = 0, right = m, ans = -1;
5        while (left <= right) {
6            int mid = (left + right) / 2;
7            if (canZero(nums, queries, mid)) {
8                ans = mid;
9                right = mid - 1;
10            } else {
11                left = mid + 1;
12            }
13        }
14        return ans;
15    }
16
17    private boolean canZero(int[] nums, int[][] queries, int k) {
18        int n = nums.length;
19        for (int i = 0; i < n; i++) {
20            int target = nums[i];
21            if (target == 0) continue;
22            boolean[] dp = new boolean[target + 1];
23            dp[0] = true;
24            for (int q = 0; q < k; q++) {
25                int l = queries[q][0];
26                int r = queries[q][1];
27                int val = queries[q][2];
28                if (l <= i && i <= r && val <= target) {
29                    for (int s = target; s >= val; s--) {
30                        if (!dp[s] && dp[s - val]) dp[s] = true;
31                    }
32                }
33            }
34            if (!dp[target]) return false;
35        }
36        return true;
37    }
38}