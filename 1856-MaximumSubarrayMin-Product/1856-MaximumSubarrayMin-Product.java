// Last updated: 13/02/2026, 21:21:18
1class Solution {
2    public int maxSumMinProduct(int[] n) {
3    Stack<Integer> st = new Stack<>();
4    long dp[] = new long[n.length + 1], res = 0;
5    for (int i = 0; i < n.length; ++i)
6       dp[i + 1] = dp[i] + n[i];
7    for (int i = 0; i <= n.length; ++i) {
8        while (!st.empty() && (i == n.length || n[st.peek()] > n[i])) {
9            int j = st.pop();
10            res = Math.max(res, (dp[i] - dp[st.empty() ? 0 : st.peek() + 1]) * n[j]);
11        }
12        st.push(i);
13    }
14    return (int)(res % 1000000007);
15}
16}