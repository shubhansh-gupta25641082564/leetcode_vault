// Last updated: 03/01/2026, 20:54:51
1class Solution {
2    public int minLength(int[] nums, int k) {
3        int n = nums.length;
4        Map<Integer, Integer> c = new HashMap<>();
5        long dS = 0;
6        int left = 0, ans = Integer.MAX_VALUE;
7
8        for(int right = 0; right < n; right ++) {
9            int x = nums[right];
10            int count = c.getOrDefault(x, 0);
11            if(count == 0) {
12                dS += x;
13            }
14            c.put(x, count + 1);
15
16            while(left <= right && dS >= k) {
17                ans = Math.min(ans, right-left+1);
18                int y = nums[left++];
19                int cy = c.get(y) - 1;
20                if(cy==0){
21                    c.remove(y);
22                    dS -= y;
23                }
24                else {
25                    c.put(y, cy);
26                }
27            }
28        }
29        return ans == Integer.MAX_VALUE ? -1 : ans;
30    }
31}