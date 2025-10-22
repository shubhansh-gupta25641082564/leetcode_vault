// Last updated: 22/10/2025, 19:22:48
import java.util.*;
class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer, Integer> count = new HashMap<>();
        TreeMap<Integer, Integer> diff = new TreeMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            diff.put(num, diff.getOrDefault(num, 0)); // Ensures the num is included as a boundary
            diff.put(num - k, diff.getOrDefault(num - k, 0) + 1);
            diff.put(num + k + 1, diff.getOrDefault(num + k + 1, 0) - 1);
        }
        int maxFreq = 0;
        int active = 0;
        for (Map.Entry<Integer, Integer> entry : diff.entrySet()) {
            int x = entry.getKey();
            int delta = entry.getValue();
            active += delta;
            int freq = Math.min(active, count.getOrDefault(x, 0) + numOperations);
            maxFreq = Math.max(maxFreq, freq);
        }
        return maxFreq;
    }
}
