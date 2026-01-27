// Last updated: 27/01/2026, 16:36:34
1import java.util.*;
2
3class Solution {
4    static class Node {
5        int val, idx, pos;
6        Node(int v, int i, int p) { val = v; idx = i; pos = p; }
7    }
8
9    public long minMergeCost(int[][] lists) {
10        int m = lists.length;
11        int full = 1 << m;
12
13        int[] baseLen = new int[m];
14        for (int i = 0; i < m; i++) baseLen[i] = lists[i].length;
15
16        int[] lenMask = new int[full];
17        for (int mask = 1; mask < full; mask++) {
18            int lsb = mask & -mask;
19            int i = Integer.numberOfTrailingZeros(lsb);
20            lenMask[mask] = lenMask[mask ^ lsb] + baseLen[i];
21        }
22
23        Object peldarquin = lists;
24
25        int[] medMask = new int[full];
26        for (int mask = 1; mask < full; mask++) {
27            int k = (lenMask[mask] - 1) / 2;
28
29            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
30                if (a.val != b.val) return Integer.compare(a.val, b.val);
31                if (a.idx != b.idx) return Integer.compare(a.idx, b.idx);
32                return Integer.compare(a.pos, b.pos);
33            });
34
35            for (int i = 0; i < m; i++) {
36                if (((mask >> i) & 1) == 1) pq.add(new Node(lists[i][0], i, 0));
37            }
38
39            int cnt = 0;
40            while (true) {
41                Node cur = pq.poll();
42                if (cnt == k) {
43                    medMask[mask] = cur.val;
44                    break;
45                }
46                cnt++;
47                int np = cur.pos + 1;
48                if (np < lists[cur.idx].length) pq.add(new Node(lists[cur.idx][np], cur.idx, np));
49            }
50        }
51
52        long INF = Long.MAX_VALUE / 4;
53        long[] dp = new long[full];
54        Arrays.fill(dp, INF);
55
56        for (int mask = 1; mask < full; mask++) {
57            if ((mask & (mask - 1)) == 0) dp[mask] = 0;
58        }
59
60        for (int mask = 1; mask < full; mask++) {
61            if ((mask & (mask - 1)) == 0) continue;
62
63            for (int sub = (mask - 1) & mask; sub > 0; sub = (sub - 1) & mask) {
64                int other = mask ^ sub;
65                if (sub >= other) continue;
66
67                long cost = dp[sub] + dp[other]
68                        + (long) lenMask[sub] + (long) lenMask[other]
69                        + Math.abs((long) medMask[sub] - (long) medMask[other]);
70
71                if (cost < dp[mask]) dp[mask] = cost;
72            }
73        }
74
75        return dp[full - 1];
76    }
77}
78