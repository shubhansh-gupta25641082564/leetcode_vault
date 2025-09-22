// Last updated: 22/09/2025, 23:01:27
import java.util.*;

class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        // Count the frequency of each number
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        int lucky = -1;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            
            // Check if number is lucky
            if (num == count) {
                lucky = Math.max(lucky, num); // keep the largest lucky number
            }
        }
        
        return lucky;
    }
}
