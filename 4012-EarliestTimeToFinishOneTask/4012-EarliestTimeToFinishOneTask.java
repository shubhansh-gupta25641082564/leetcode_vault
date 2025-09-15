// Last updated: 15/09/2025, 22:04:59
class Solution {
    public int earliestTime(int[][] tasks) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < tasks.length; i ++)
            {
                ans = Math.min(ans, (tasks[i][0] + tasks[i][1]));
            }
        return ans;
    }
}