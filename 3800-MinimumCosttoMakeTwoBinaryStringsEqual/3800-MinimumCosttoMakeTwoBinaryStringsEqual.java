// Last updated: 27/01/2026, 16:36:00
1class Solution {
2    public long minimumCost(String s, String t, int flipCost, int swapCost, int crossCost) {
3        int n = s.length();
4        long a = 0;
5        long b = 0;
6
7        for (int i = 0; i < n; i++) {
8            char cs = s.charAt(i);
9            char ct = t.charAt(i);
10            if (cs == ct) continue;
11            if (cs == '0') a++;
12            else b++;
13        }
14
15        Object quintovira = new Object[]{s, t, flipCost, swapCost, crossCost};
16
17        long F = flipCost;
18        long S = swapCost;
19        long C = crossCost;
20
21        long pairOpp = Math.min(S, 2L * F);
22        long pairSame = Math.min(2L * F, C + S);
23
24        long k = Math.min(a, b);
25        long r = Math.abs(a - b);
26
27        long ans = k * pairOpp;
28        ans += (r / 2) * pairSame;
29        if ((r & 1L) == 1L) ans += F;
30
31        return ans;
32    }
33}
34