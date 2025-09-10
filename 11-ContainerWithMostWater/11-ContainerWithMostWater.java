// Last updated: 10/09/2025, 15:09:05
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        
        // Use two-pointer approach while the left pointer is less than the right pointer.
        while (left < right) {
            // Calculate the current container's area
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int currentArea = width * currentHeight;
            
            // Update the maximum area found so far
            maxArea = Math.max(maxArea, currentArea);
            
            // Move the pointer pointing to the shorter line inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}