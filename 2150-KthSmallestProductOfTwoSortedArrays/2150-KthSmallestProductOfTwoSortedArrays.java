// Last updated: 05/10/2025, 00:08:40
class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int n1 = nums1.length, n2 = nums2.length;
        // Search space: products lie between -1e10 and +1e10
        long lo = -100_000L * 100_000L, hi = 100_000L * 100_000L;
        
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (countLE(nums1, nums2, mid) >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    
    // Count how many pairs (i,j) satisfy nums1[i] * nums2[j] <= x
    private long countLE(int[] a, int[] b, long x) {
        int n = a.length, m = b.length;
        long cnt = 0;
        for (long v : a) {
            if (v == 0) {
                if (x >= 0) {
                    // 0 * anything == 0 ≤ x
                    cnt += m;
                }
            } else if (v > 0) {
                // For positive v, we want b[j] ≤ floor(x/v)
                // find first index j where v*b[j] > x → count = j
                int low = 0, high = m;
                while (low < high) {
                    int mid = (low + high) >>> 1;
                    if (v * b[mid] <= x) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
                cnt += low;
            } else { // v < 0
                // For negative v, v*b[j] is decreasing in j.
                // find first index j where v*b[j] ≤ x → count += (m - j)
                int low = 0, high = m;
                while (low < high) {
                    int mid = (low + high) >>> 1;
                    if (v * b[mid] <= x) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }
                cnt += (m - low);
            }
        }
        return cnt;
    }
}
