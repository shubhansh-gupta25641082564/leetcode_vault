// Last updated: 10/09/2025, 15:08:56
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Edge case: if array has less than 4 elements, return empty result.
        if (nums == null || nums.length < 4) {
            return result;
        }
        
        // Sort the array to use two-pointer technique and to easily skip duplicates.
        Arrays.sort(nums);
        int n = nums.length;
        
        // First loop: choose the first element of quadruplet.
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates for i.
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            // Second loop: choose the second element of quadruplet.
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates for j.
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                
                // Two pointers for the remaining two numbers.
                int left = j + 1;
                int right = n - 1;
                
                while (left < right) {
                    long currentSum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    
                    // If found a quadruplet that sums to target, add it.
                    if (currentSum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        // Move left pointer to the next different number.
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        // Move right pointer to the next different number.
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        
                        left++;
                        right--;
                    } else if (currentSum < target) {
                        // Increase sum by moving left pointer.
                        left++;
                    } else {
                        // Decrease sum by moving right pointer.
                        right--;
                    }
                }
            }
        }
        return result;
    }
}