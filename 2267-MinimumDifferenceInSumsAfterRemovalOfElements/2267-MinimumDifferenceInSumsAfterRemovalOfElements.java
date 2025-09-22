// Last updated: 22/09/2025, 16:13:33
import java.util.*;
class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        int len = nums.length;

        long[] prefixSum = new long[len];
        long[] suffixSum = new long[len];

        // Prefix heap: max heap to track smallest n elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for (int i = 0; i < 2 * n; i++) {
            sum += nums[i];
            maxHeap.offer(nums[i]);
            if (maxHeap.size() > n) {
                sum -= maxHeap.poll();
            }
            if (maxHeap.size() == n) {
                prefixSum[i] = sum;
            } else {
                prefixSum[i] = Long.MAX_VALUE;  // mark as invalid
            }
        }

        // Suffix heap: min heap to track largest n elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        sum = 0;
        for (int i = len - 1; i >= n; i--) {
            sum += nums[i];
            minHeap.offer(nums[i]);
            if (minHeap.size() > n) {
                sum -= minHeap.poll();
            }
            if (minHeap.size() == n) {
                suffixSum[i] = sum;
            } else {
                suffixSum[i] = Long.MIN_VALUE; // mark as invalid
            }
        }

        // Find minimum difference
        long minDiff = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            if (suffixSum[i + 1] != Long.MIN_VALUE) {
                minDiff = Math.min(minDiff, prefixSum[i] - suffixSum[i + 1]);
            }
        }

        return minDiff;
    }
}