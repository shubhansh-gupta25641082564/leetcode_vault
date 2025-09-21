// Last updated: 21/09/2025, 16:54:21
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(robLinear(nums, 0, n - 2), robLinear(nums, 1, n - 1));
    }
    private int robLinear(int[] a, int l, int r) {
        int prev = 0, cur = 0;
        for (int i = l; i <= r; ++i) {
            int nxt = Math.max(cur, prev + a[i]);
            prev = cur;
            cur = nxt;
        }
        return cur;
    }
}
