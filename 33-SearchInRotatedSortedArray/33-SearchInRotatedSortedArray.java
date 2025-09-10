// Last updated: 10/09/2025, 15:08:38
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // If the mid element is the target, return its index.
            if (nums[mid] == target) {
                return mid;
            }
            
            // Check which half is sorted.
            if (nums[left] <= nums[mid]) {
                // The left half is sorted.
                if (nums[left] <= target && target < nums[mid]) {
                    // Target lies in the sorted left half.
                    right = mid - 1;
                } else {
                    // Target lies in the unsorted right half.
                    left = mid + 1;
                }
            } else {
                // The right half is sorted.
                if (nums[mid] < target && target <= nums[right]) {
                    // Target lies in the sorted right half.
                    left = mid + 1;
                } else {
                    // Target lies in the unsorted left half.
                    right = mid - 1;
                }
            }
        }
        
        // If no match was found.
        return -1;
    }
}