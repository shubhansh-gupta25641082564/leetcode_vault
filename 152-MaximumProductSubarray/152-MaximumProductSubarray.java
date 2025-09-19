// Last updated: 20/09/2025, 00:03:21
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];
        for (int i = 1; i < n; i++) {
            int x = nums[i];
            int a = maxProd * x;
            int b = minProd * x;
            int currMax = Math.max(x, Math.max(a, b));
            int currMin = Math.min(x, Math.min(a, b));
            maxProd = currMax;
            minProd = currMin;
            result = Math.max(result, maxProd);
        }
        return result;
    }
}
