// Last updated: 20/09/2025, 00:31:35
class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                high = mid;
            } else { // nums[mid] == nums[high]
                high--;
            }
        }
        return nums[low];
    }
}
