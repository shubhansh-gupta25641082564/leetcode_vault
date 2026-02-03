// Last updated: 03/02/2026, 19:44:12
1class Solution {
2    public boolean isTrionic(int[] nums) {
3        int n = nums.length;
4        int i = 0;
5
6        while (i + 1 < n && nums[i] < nums[i + 1]) i++;
7        if (i == 0 || i == n - 1) return false;
8
9        int p = i;
10
11        while (i + 1 < n && nums[i] > nums[i + 1]) i++;
12        if (i == p || i == n - 1) return false;
13
14        while (i + 1 < n && nums[i] < nums[i + 1]) i++;
15
16        return i == n - 1;
17    }
18}
19