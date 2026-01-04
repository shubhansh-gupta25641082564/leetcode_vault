// Last updated: 04/01/2026, 09:44:46
1class Solution {
2    public int findMaxVal(int n, int[][] restrictions, int[] diff) {
3        int[][] arr = restrictions;
4        long in = (long) 4e18;
5        long[] lim = new long[n];
6        Arrays.fill(lim, in);
7        lim[0] = 0;
8
9        for(int[] r : arr) {
10            int idx = r[0];
11            int max = r[1];
12            if(max < lim[idx]) {
13                lim[idx] = max;
14            }
15        }
16        for(int i = 0; i < n - 1; i ++) {
17            long reach = lim[i] + diff[i];
18            if(reach < lim[i +1]) {
19                lim[i +1] = reach;
20            }
21        }
22        for(int i = n -2; i >= 0; i --) {
23            long reach = lim[i + 1] + diff[i];
24            if(reach < lim[i]) {
25                lim[i] = reach;
26            }
27        }
28        long b = 0;
29        for(int i = 0; i < n; i ++) {
30            b = Math.max(b, lim[i]);
31        }
32        return (int)b;
33    }
34}