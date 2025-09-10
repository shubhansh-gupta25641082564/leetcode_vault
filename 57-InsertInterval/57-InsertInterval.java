// Last updated: 10/09/2025, 15:08:10
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> output = new ArrayList<>();
        int newStart = newInterval[0], newEnd = newInterval[1];
        int i = 0, n = intervals.length;

        // 1) Add all intervals that end before newInterval starts (no overlap).
        while (i < n && intervals[i][1] < newStart) {
            output.add(intervals[i]);
            i++;
        }

        // 2) Merge all intervals that overlap with newInterval.
        //    Overlap occurs if intervals[i].start <= newEnd.
        while (i < n && intervals[i][0] <= newEnd) {
            newStart = Math.min(newStart, intervals[i][0]);
            newEnd   = Math.max(newEnd,   intervals[i][1]);
            i++;
        }
        // Add the merged interval
        output.add(new int[]{newStart, newEnd});

        // 3) Add the remaining intervals (start after newEnd).
        while (i < n) {
            output.add(intervals[i]);
            i++;
        }

        // Convert list back to a 2D array
        return output.toArray(new int[output.size()][]);
    }
}