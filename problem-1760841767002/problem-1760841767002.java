// Last updated: 19/10/2025, 08:12:47
class Solution {
    public int missingMultiple(int[] nums, int k) {
        int ans = 0, i = k;
        while (true) {
            if (IsMissing(nums, k)) {
                ans = k;
                break;
            }
            k += i;
        }
        return ans;
    }
    public boolean IsMissing(int[] nums, int k) {
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == k) {
                return false;
            }
        }
        return true;
    }
}