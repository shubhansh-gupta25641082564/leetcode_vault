// Last updated: 11/02/2026, 12:29:15
1import java.util.*;
2
3class Solution {
4    public int findMaximumXOR(int[] nums) {
5        int max = 0;
6        int mask = 0;
7        for (int k = 31; k >= 0; k--) {
8            mask |= (1 << k);
9            Set<Integer> prefixes = new HashSet<>();
10            for (int v : nums) prefixes.add(v & mask);
11            int candidate = max | (1 << k);
12            boolean found = false;
13            for (int p : prefixes) {
14                if (prefixes.contains(p ^ candidate)) {
15                    found = true;
16                    break;
17                }
18            }
19            if (found) max = candidate;
20        }
21        return max;
22    }
23}
24