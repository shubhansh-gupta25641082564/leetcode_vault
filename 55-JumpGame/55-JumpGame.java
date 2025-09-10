// Last updated: 10/09/2025, 15:08:13
class Solution {
    public boolean canJump(int[] nums) {
        // The farthest index that can be reached so far.
        int reachable = 0;
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current index is beyond the farthest index we can reach, return false.
            if (i > reachable) {
                return false;
            }
            // Update reachable: maximum of current reachable or i + nums[i]
            reachable = Math.max(reachable, i + nums[i]);
            // Early exit: if we can reach or surpass the last index, return true.
            if (reachable >= nums.length - 1) {
                return true;
            }
        }
        
        // If the loop completes without reaching the last index, return false.
        return false;
    }
}