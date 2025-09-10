// Last updated: 10/09/2025, 15:08:11
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        
        // 1. Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> merged = new ArrayList<>();
        // Start with the first interval
        int[] current = intervals[0];
        merged.add(current);
        
        for (int[] next : intervals) {
            int currEnd = current[1];
            int nextStart = next[0];
            int nextEnd = next[1];
            
            if (nextStart <= currEnd) {
                // Overlaps: extend the current interval's end if needed
                current[1] = Math.max(currEnd, nextEnd);
            } else {
                // No overlap: move on to the next interval
                current = next;
                merged.add(current);
            }
        }
        
        // Convert list back to array
        return merged.toArray(new int[merged.size()][]);
    }
}