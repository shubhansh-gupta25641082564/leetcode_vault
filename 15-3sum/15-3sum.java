// Last updated: 10/09/2025, 15:09:00
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Edge case: if nums is null or has less than 3 numbers, there cannot be any triplets.
        if (nums == null || nums.length < 3) {
            return result;
        }
        
        // Sort the array to enable the two-pointer approach and simplify duplicate handling.
        Arrays.sort(nums);
        
        // Iterate over the array, fixing one element at a time.
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements to avoid duplicate triplets.
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = nums.length - 1;
            
            // Use two pointers to find pairs that sum up to -nums[i].
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                // If the sum is zero, we found a valid triplet.
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Move the left pointer forward while skipping duplicates.
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Move the right pointer backward while skipping duplicates.
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    // Increase the sum by moving the left pointer to the right.
                    left++;
                } else {
                    // Decrease the sum by moving the right pointer to the left.
                    right--;
                }
            }
        }
        
        return result;
    }
}