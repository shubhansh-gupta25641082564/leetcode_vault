// Last updated: 22/09/2025, 16:13:44
import java.util.Arrays;

class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]); // sort by end day
        int n = events.length;
        int[][] dp = new int[k + 1][n + 1];

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                // skip current event
                dp[i][j] = dp[i][j-1];

                // attend current event
                int prevIndex = binarySearch(events, j-1); // last non-overlapping event
                dp[i][j] = Math.max(dp[i][j], events[j-1][2] + dp[i-1][prevIndex+1]);
            }
        }

        return dp[k][n];
    }

    // find the last event that ends before events[index] starts
    private int binarySearch(int[][] events, int index) {
        int l = 0, r = index - 1, ans = -1;
        int start = events[index][0];
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (events[mid][1] < start) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
