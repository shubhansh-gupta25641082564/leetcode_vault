// Last updated: 13/01/2026, 11:42:28
1import java.util.ArrayList;
2import java.util.Arrays;
3import java.util.List;
4
5class Solution {
6    public List<List<Integer>> threeSum(int[] nums) {
7        List<List<Integer>> result = new ArrayList<>();
8        
9        // Edge case: if nums is null or has less than 3 numbers, there cannot be any triplets.
10        if (nums == null || nums.length < 3) {
11            return result;
12        }
13        
14        // Sort the array to enable the two-pointer approach and simplify duplicate handling.
15        Arrays.sort(nums);
16        
17        // Iterate over the array, fixing one element at a time.
18        for (int i = 0; i < nums.length - 2; i++) {
19            // Skip duplicate elements to avoid duplicate triplets.
20            if (i > 0 && nums[i] == nums[i - 1]) continue;
21            
22            int left = i + 1;
23            int right = nums.length - 1;
24            
25            // Use two pointers to find pairs that sum up to -nums[i].
26            while (left < right) {
27                int sum = nums[i] + nums[left] + nums[right];
28                
29                // If the sum is zero, we found a valid triplet.
30                if (sum == 0) {
31                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
32                    
33                    // Move the left pointer forward while skipping duplicates.
34                    while (left < right && nums[left] == nums[left + 1]) left++;
35                    // Move the right pointer backward while skipping duplicates.
36                    while (left < right && nums[right] == nums[right - 1]) right--;
37                    
38                    left++;
39                    right--;
40                } else if (sum < 0) {
41                    // Increase the sum by moving the left pointer to the right.
42                    left++;
43                } else {
44                    // Decrease the sum by moving the right pointer to the left.
45                    right--;
46                }
47            }
48        }
49        
50        return result;
51    }
52}