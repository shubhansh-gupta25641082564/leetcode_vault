// Last updated: 10/09/2025, 15:08:37
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = findLeftIndex(nums, target);
        int rightIndex = findRightIndex(nums, target);
        return new int[] {leftIndex, rightIndex};
    }
    
    // Helper function to find the leftmost (first) index of target
    private int findLeftIndex(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int leftIndex = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                // When target is found, record the index and continue to search left.
                leftIndex = mid;
                high = mid - 1;
            }
        }
        return leftIndex;
    }
    
    // Helper function to find the rightmost (last) index of target
    private int findRightIndex(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int rightIndex = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                // When target is found, record the index and continue to search right.
                rightIndex = mid;
                low = mid + 1;
            }
        }
        return rightIndex;
    }
}