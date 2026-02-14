// Last updated: 14/02/2026, 22:26:15
1import java.util.*;
2
3class Solution {
4    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
5        int[][] suneravilo = edges;
6
7        int m = n - 1;
8        int[] head = new int[n];
9        Arrays.fill(head, -1);
10        int[] to = new int[2 * m];
11        int[] next = new int[2 * m];
12        int ei = 0;
13        for (int[] e : suneravilo) {
14            int u = e[0], v = e[1];
15            to[ei] = v; next[ei] = head[u]; head[u] = ei++;
16            to[ei] = u; next[ei] = head[v]; head[v] = ei++;
17        }
18
19        char[] arr = s.toCharArray();
20        int[] mask = new int[n];
21        for (int i = 0; i < n; i++) mask[i] = 1 << (arr[i] - 'a');
22
23        int[] parent = new int[n];
24        int[] depth = new int[n];
25        int[] order = new int[n];
26        int[] st = new int[n];
27        int sp = 0, ord = 0;
28
29        Arrays.fill(parent, -1);
30        st[sp++] = 0;
31        parent[0] = -1;
32        depth[0] = 0;
33
34        while (sp > 0) {
35            int u = st[--sp];
36            order[ord++] = u;
37            for (int e = head[u]; e != -1; e = next[e]) {
38                int v = to[e];
39                if (v == parent[u]) continue;
40                parent[v] = u;
41                depth[v] = depth[u] + 1;
42                st[sp++] = v;
43            }
44        }
45
46        int[] size = new int[n];
47        int[] heavy = new int[n];
48        Arrays.fill(heavy, -1);
49
50        for (int i = n - 1; i >= 0; i--) {
51            int u = order[i];
52            int best = 0;
53            size[u] = 1;
54            for (int e = head[u]; e != -1; e = next[e]) {
55                int v = to[e];
56                if (v == parent[u]) continue;
57                size[u] += size[v];
58                if (size[v] > best) {
59                    best = size[v];
60                    heavy[u] = v;
61                }
62            }
63        }
64
65        int[] chainHead = new int[n];
66        int[] pos = new int[n];
67        int cur = 1;
68
69        int[] nodeStack = new int[n];
70        int[] headStack = new int[n];
71        int top = 0;
72        nodeStack[top] = 0;
73        headStack[top] = 0;
74        top++;
75
76        while (top > 0) {
77            int u = nodeStack[--top];
78            int h = headStack[top];
79
80            while (u != -1) {
81                chainHead[u] = h;
82                pos[u] = cur++;
83
84                int hc = heavy[u];
85                for (int e = head[u]; e != -1; e = next[e]) {
86                    int v = to[e];
87                    if (v == parent[u] || v == hc) continue;
88                    nodeStack[top] = v;
89                    headStack[top] = v;
90                    top++;
91                }
92                u = hc;
93            }
94        }
95
96        FenwickXor fw = new FenwickXor(n);
97        for (int i = 0; i < n; i++) fw.add(pos[i], mask[i]);
98
99        ArrayList<Boolean> ans = new ArrayList<>();
100        for (String q : queries) {
101            char t = q.charAt(0);
102            if (t == 'u') {
103                int p = 7;
104                int u = 0;
105                while (q.charAt(p) != ' ') {
106                    u = u * 10 + (q.charAt(p) - '0');
107                    p++;
108                }
109                char c = q.charAt(p + 1);
110                int nm = 1 << (c - 'a');
111                int delta = mask[u] ^ nm;
112                if (delta != 0) {
113                    mask[u] = nm;
114                    arr[u] = c;
115                    fw.add(pos[u], delta);
116                }
117            } else {
118                int p = 6;
119                int u = 0;
120                while (q.charAt(p) != ' ') {
121                    u = u * 10 + (q.charAt(p) - '0');
122                    p++;
123                }
124                p++;
125                int v = 0;
126                while (p < q.length()) {
127                    v = v * 10 + (q.charAt(p) - '0');
128                    p++;
129                }
130
131                int x = pathXor(u, v, parent, depth, chainHead, pos, fw);
132                ans.add(Integer.bitCount(x) <= 1);
133            }
134        }
135
136        return ans;
137    }
138
139    private int pathXor(int a, int b, int[] parent, int[] depth, int[] chainHead, int[] pos, FenwickXor fw) {
140        int res = 0;
141        while (chainHead[a] != chainHead[b]) {
142            if (depth[chainHead[a]] < depth[chainHead[b]]) {
143                int tmp = a; a = b; b = tmp;
144            }
145            int ha = chainHead[a];
146            res ^= fw.range(pos[ha], pos[a]);
147            a = parent[ha];
148            if (a == -1) break;
149        }
150        if (a != -1) {
151            if (depth[a] < depth[b]) {
152                int tmp = a; a = b; b = tmp;
153            }
154            res ^= fw.range(pos[b], pos[a]);
155        }
156        return res;
157    }
158
159    static class FenwickXor {
160        int n;
161        int[] bit;
162        FenwickXor(int n) {
163            this.n = n;
164            this.bit = new int[n + 2];
165        }
166        void add(int i, int v) {
167            for (int x = i; x <= n; x += x & -x) bit[x] ^= v;
168        }
169        int sum(int i) {
170            int r = 0;
171            for (int x = i; x > 0; x -= x & -x) r ^= bit[x];
172            return r;
173        }
174        int range(int l, int r) {
175            return sum(r) ^ sum(l - 1);
176        }
177    }
178}
179