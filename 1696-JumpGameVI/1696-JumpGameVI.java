// Last updated: 30/01/2026, 13:10:58
1import java.util.*;
2
3class Solution {
4    public int maxResult(int[] nums, int k) {
5        int n = nums.length;
6        int[] dp = new int[n];
7        dp[0] = nums[0];
8
9        Deque<Integer> dq = new ArrayDeque<>();
10        dq.offerLast(0);
11
12        for (int i = 1; i < n; i++) {
13            while (!dq.isEmpty() && dq.peekFirst() < i - k) dq.pollFirst();
14
15            dp[i] = nums[i] + dp[dq.peekFirst()];
16
17            while (!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]) dq.pollLast();
18            dq.offerLast(i);
19        }
20        return dp[n - 1];
21    }
22}