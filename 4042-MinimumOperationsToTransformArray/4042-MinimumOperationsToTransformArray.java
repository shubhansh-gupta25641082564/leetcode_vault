// Last updated: 02/11/2025, 23:39:17
class Solution {
    public long minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        long base = 0;
        for (int i = 0; i < n; i++) {
            base += Math.abs((long)nums2[i] - nums1[i]);
        }
        long last = nums2[n];
        long best = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long a = nums1[i], b = nums2[i];
            long hi = Math.max(last, Math.max(a, b));
            long lo = Math.min(last, Math.min(a, b));
            long delta = (hi - lo) - Math.abs(b - a);
            if (delta < best) best = delta;
        }
        return base + best + 1;
    }
}