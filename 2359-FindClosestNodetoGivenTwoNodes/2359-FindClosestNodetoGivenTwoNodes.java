// Last updated: 27/01/2026, 17:34:16
1class Solution {
2    public int closestMeetingNode(int[] edges, int node1, int node2) {
3        int n = edges.length;
4        int[] dist1 = new int[n];
5        int[] dist2 = new int[n];
6        Arrays.fill(dist1, -1);
7        Arrays.fill(dist2, -1);
8        int cur = node1, step = 0;
9        while (cur != -1 && dist1[cur] == -1) {
10            dist1[cur] = step ++;
11            cur = edges[cur];
12        }
13        cur = node2;
14        step = 0;
15        while (cur != -1 && dist2[cur] == -1) {
16            dist2[cur] = step ++;
17            cur = edges[cur];
18        }
19        int ans = -1;
20        int best = Integer.MAX_VALUE;
21        for (int i = 0; i < n; i++) {
22            if (dist1[i] == -1 || dist2[i] == -1) {
23                continue;
24            }
25            int val = Math.max(dist1[i], dist2[i]);
26            if (val < best) {
27                best = val;
28                ans = i;
29            }
30        }
31        return ans;
32    }
33}