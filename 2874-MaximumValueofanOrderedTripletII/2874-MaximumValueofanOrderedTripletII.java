// Last updated: 13/02/2026, 21:29:05
1class Solution {
2    public int maxFrequency(int[] nums, int k) {
3        int max = 0, ck = 0;
4        int[] prefix = new int[51];
5
6        for(int i = 0; i < nums.length; i++) {
7            if(nums[i] == k) {
8                ck++;
9                prefix[k] = max + 1;
10            } else {
11                prefix[nums[i]] = Math.max(prefix[nums[i]], ck) + 1;
12            }
13            max = Math.max(max, prefix[nums[i]]);
14        }
15
16        return max;
17    }
18}