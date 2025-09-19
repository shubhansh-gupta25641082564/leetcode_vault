// Last updated: 20/09/2025, 00:31:28
import java.util.Arrays;

class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int v : nums) {
            if (v < min) min = v;
            if (v > max) max = v;
        }
        if (min == max) return 0; // all equal

        long range = (long) max - (long) min;
        long bucketSize = Math.max(1L, (range + n - 2) / (n - 1)); // ceil(range/(n-1))
        int bucketCount = (int) (range / bucketSize) + 1;

        long[] bucketMin = new long[bucketCount];
        long[] bucketMax = new long[bucketCount];
        Arrays.fill(bucketMin, Long.MAX_VALUE);
        Arrays.fill(bucketMax, Long.MIN_VALUE);

        for (int v : nums) {
            int idx = (int) ((v - min) / bucketSize);
            bucketMin[idx] = Math.min(bucketMin[idx], v);
            bucketMax[idx] = Math.max(bucketMax[idx], v);
        }

        long prev = min;
        long maxGap = 0;
        for (int i = 0; i < bucketCount; i++) {
            if (bucketMin[i] == Long.MAX_VALUE) continue; // empty bucket
            maxGap = Math.max(maxGap, bucketMin[i] - prev);
            prev = bucketMax[i];
        }

        return (int) maxGap;
    }
}
