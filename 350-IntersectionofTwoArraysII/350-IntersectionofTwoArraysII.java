// Last updated: 21/09/2025, 20:10:24
import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersect(nums2, nums1);
        
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums1) countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        
        List<Integer> resultList = new ArrayList<>();
        for (int num : nums2) {
            if (countMap.getOrDefault(num, 0) > 0) {
                resultList.add(num);
                countMap.put(num, countMap.get(num) - 1);
            }
        }
        
        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) result[i] = resultList.get(i);
        return result;
    }
}