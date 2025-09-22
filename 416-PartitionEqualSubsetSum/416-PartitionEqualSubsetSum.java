// Last updated: 22/09/2025, 10:31:23
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int v : nums) sum += v;
        if ((sum & 1) == 1) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int v : nums) {
            for (int j = target; j >= v; j--) {
                if (dp[j - v]) dp[j] = true;
            }
            if (dp[target]) return true;
        }
        return dp[target];
    }
}
