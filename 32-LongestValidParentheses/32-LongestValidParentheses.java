// Last updated: 10/09/2025, 15:08:39
class Solution {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        int n = s.length();
        int[] dp = new int[n]; // dp[i] stores the longest valid substring ending at i

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    // Case: "()", directly add 2
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // Case: "(()...)", check for valid opening before the current valid sequence
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }
}