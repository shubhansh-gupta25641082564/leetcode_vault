// Last updated: 22/10/2025, 19:22:49
import java.util.*;

class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        int n = nums.length;
        long[][] intervals = new long[n][2];
        for (int i = 0; i < n; i++) {
            long L = (long) nums[i] - k;
            long R = (long) nums[i] + k;
            intervals[i][0] = L;
            intervals[i][1] = R;
        }

        Arrays.sort(intervals, (a, b) -> Long.compare(a[1], b[1]));

        long last = Long.MIN_VALUE / 2; // strictly increasing assigned integers
        int count = 0;

        for (long[] itv : intervals) {
            long L = itv[0], R = itv[1];
            long candidate = Math.max(L, last + 1);
            if (candidate <= R) {
                count++;
                last = candidate;
            }
        }

        return count;
    }
}
