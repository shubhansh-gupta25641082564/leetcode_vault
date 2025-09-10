// Last updated: 10/09/2025, 15:08:58
import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array to use two pointers.
        Arrays.sort(nums);
        // Initialize the best sum with a large initial value.
        // It can be the sum of the first three elements.
        int bestSum = nums[0] + nums[1] + nums[2];
        
        // Iterate through each number in the array.
        for (int i = 0; i < nums.length - 2; i++) {
            // Set left and right pointers for the current i.
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                
                // If the current sum is exactly the target, return it immediately.
                if (currentSum == target) {
                    return currentSum;
                }
                
                // Update bestSum if the current sum is closer to target.
                if (Math.abs(currentSum - target) < Math.abs(bestSum - target)) {
                    bestSum = currentSum;
                }
                
                // Adjust pointers based on current sum comparison to target.
                if (currentSum < target) {
                    left++;  // Increase the sum by moving left pointer right.
                } else {
                    right--; // Decrease the sum by moving right pointer left.
                }
            }
        }
        
        return bestSum;
    }
}