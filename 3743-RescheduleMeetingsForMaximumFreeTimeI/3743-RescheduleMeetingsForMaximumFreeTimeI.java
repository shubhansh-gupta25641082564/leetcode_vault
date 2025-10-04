// Last updated: 05/10/2025, 00:08:14
class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        long[] durPrefix = new long[n+1];
        // Build prefix sums of meeting durations
        for (int i = 0; i < n; i++) {
            durPrefix[i+1] = durPrefix[i] + (endTime[i] - startTime[i]);
        }

        long bestFree = 0;
        // Slide a window of size k over meeting indices
        for (int l = 0; l + k <= n; l++) {
            // Sum of durations of meetings l..l+k-1
            long removedDur = durPrefix[l + k] - durPrefix[l];

            // End of the meeting just before the block, or 0 if l==0
            long leftBoundary = (l > 0 ? endTime[l - 1] : 0);
            // Start of the meeting just after the block, or eventTime if l+k==n
            long rightBoundary = (l + k < n ? startTime[l + k] : eventTime);

            long gap = rightBoundary - leftBoundary;
            long freeWindow = gap - removedDur;
            if (freeWindow > bestFree) {
                bestFree = freeWindow;
            }
        }

        // bestFree is guaranteed ≥ 0
        return (int) bestFree;
    }
}
