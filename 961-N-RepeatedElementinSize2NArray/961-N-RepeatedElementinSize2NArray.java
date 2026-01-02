// Last updated: 02/01/2026, 11:09:40
1class Solution {
2    public int repeatedNTimes(int[] nums) {
3        int[] freq = new int[10000];
4        for (int i = 0; i < nums.length; i ++) {
5            freq[nums[i]] ++;
6        }
7        int r = 0;
8        for (int i = 0; i < freq.length; i ++) {
9            if (freq[i] > 1) {
10                r = i;
11            }
12        }
13        return r;
14    }
15}