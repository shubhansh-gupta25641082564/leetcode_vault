// Last updated: 10/09/2025, 15:07:46
class Solution {
    public void sortColors(int[] nums) {
        int low = 0;            // next position for 0
        int mid = 0;            // current element under consideration
        int high = nums.length - 1;  // next position for 2
        
        while (mid <= high) {
            if (nums[mid] == 0) {
                // swap nums[low] and nums[mid], expand 0-region
                int tmp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = tmp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // 1 is in its correct region; just move on
                mid++;
            } else { // nums[mid] == 2
                // swap nums[mid] and nums[high], shrink 2-region
                int tmp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = tmp;
                high--;
                // don't increment mid here, since the swapped-in element
                // must be examined
            }
        }
    }
}