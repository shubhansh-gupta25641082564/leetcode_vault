// Last updated: 22/09/2025, 16:13:10
class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n][k];
        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            for (int rem = 0; rem < k; rem++) {
                dp[i][rem] = 1;
            }

            for (int j = 0; j < i; j++) {
                int r = (nums[j] + nums[i]) % k;
                dp[i][r] = Math.max(dp[i][r], dp[j][r] + 1);
                maxLen = Math.max(maxLen, dp[i][r]);
            }
        }

        return maxLen;
    }
}