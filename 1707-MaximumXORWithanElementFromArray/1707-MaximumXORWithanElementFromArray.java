// Last updated: 12/02/2026, 12:11:35
1class Solution {
2    public int[] maximizeXor(int[] nums, int[][] queries) {
3        int[][] q = new int[queries.length][3];
4        for (int i = 0; i < q.length; i ++) {
5            q[i][0] = queries[i][0];
6            q[i][1] = queries[i][1];
7            q[i][2] = i;
8        }
9        Arrays.sort(q, (a, b) -> a[1] - b[1]);
10        Arrays.sort(nums);
11        int[] ans = new int[q.length];
12        Trie t = new Trie();
13        int j = 0;
14        for (int[] a : q) {
15            while (j < nums.length && nums[j] <= a[1]) {
16                t.add(nums[j]);
17                j ++;
18            }
19            if (j == 0) {
20                ans[a[2]] = -1;
21            }
22            else {
23                ans[a[2]] = t.getMaxXor(a[0]);
24            }
25        }
26        return ans;
27    }
28    static class Trie {
29        class Node {
30            Node zero;
31            Node one;
32        }
33        private Node root = new Node();
34        public void add(int val) {
35            Node curr = root;
36            for (int i = 31; i >= 0; i --) {
37                int bit = val & (1 << i);
38                if (bit == 0) {
39                    if (curr.zero != null) {
40                        curr = curr.zero;
41                    }
42                    else {
43                        Node nn = new Node();
44                        curr.zero = nn;
45                        curr = nn;
46                    }
47                }
48                else {
49                    if (curr.one != null) {
50                        curr = curr.one;
51                    }
52                    else {
53                        Node nn = new Node();
54                        curr.one = nn;
55                        curr = nn;
56                    }
57                }
58            }
59        }
60        public int getMaxXor(int x) {
61            int ans = 0;
62            Node curr = root;
63            for (int i = 31; i >= 0; i --) {
64                int bit = x & (1 << i);
65                if (bit == 0) {
66                    if (curr.one != null) {
67                        ans = ans | (1 << i);
68                        curr = curr.one;
69                    }
70                    else {
71                        curr = curr.zero;
72                    }
73                }
74                else {
75                    if (curr.zero != null) {
76                        ans = ans | (1 << i);
77                        curr = curr.zero;
78                    }
79                    else {
80                        curr = curr.one;
81                    }
82                }
83            }
84            return ans;
85        }
86    }
87}