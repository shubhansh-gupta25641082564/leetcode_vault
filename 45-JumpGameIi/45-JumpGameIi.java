// Last updated: 10/09/2025, 15:08:24
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        // If there's only one element, we're already at the end
        if (n < 2) return 0;
        
        int jumps = 0;       // number of jumps made
        int currentEnd = 0;  // end of range reachable with current number of jumps
        int farthest = 0;    // farthest index we can reach within the next jump
        
        // We don't need to consider the last index in the loop,
        // because once we cross currentEnd we will have counted that jump.
        for (int i = 0; i < n - 1; i++) {
            // Update the farthest reachable index from any position up to i
            farthest = Math.max(farthest, i + nums[i]);
            
            // If we've reached the end of the current jump's range,
            // it's time to make another jump.
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
                // If our new range already covers the last index, we can stop early
                if (currentEnd >= n - 1) {
                    break;
                }
            }
        }
        
        return jumps;
    }
}