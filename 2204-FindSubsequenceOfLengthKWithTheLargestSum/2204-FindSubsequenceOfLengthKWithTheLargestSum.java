// Last updated: 22/09/2025, 16:13:35
import java.util.*;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] copy = nums.clone();
        Arrays.sort(copy);
        
        // get the k largest elements
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = n - k; i < n; i++) {
            count.put(copy[i], count.getOrDefault(copy[i], 0) + 1);
        }
        
        int[] res = new int[k];
        int index = 0;
        for (int num : nums) {
            if (count.getOrDefault(num, 0) > 0) {
                res[index++] = num;
                count.put(num, count.get(num) - 1);
            }
            if (index == k) break;
        }
        return res;
    }
}
