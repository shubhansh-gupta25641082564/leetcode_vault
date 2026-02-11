// Last updated: 11/02/2026, 12:45:12
1class Solution {
2    public int findMaximumXOR(int[] nums) {
3        Trie t = new Trie();
4        for (int x : nums) {
5            t.add(x);
6        }
7        int ans = 0;
8        for (int x : nums) {
9            ans = Math.max(t.getMaxXor(x), ans);
10        }
11        return ans;
12    }
13    static class Trie {
14        class Node {
15            Node zero;
16            Node one;
17        }
18        private Node root = new Node();
19        public void add(int val) {
20            Node curr = root;
21            for (int i = 31; i >= 0; i --) {
22                int bit = val & (1 << i);
23                if (bit == 0) {
24                    if (curr.zero != null) {
25                        curr = curr.zero;
26                    }
27                    else {
28                        Node nn = new Node();
29                        curr.zero = nn;
30                        curr = nn;
31                    }
32                }
33                else {
34                    if (curr.one != null) {
35                        curr = curr.one;
36                    }
37                    else {
38                        Node nn = new Node();
39                        curr.one = nn;
40                        curr = nn;
41                    }
42                }
43            }
44        }
45        public int getMaxXor(int x) {
46            int ans = 0;
47            Node curr = root;
48            for (int i = 31; i >= 0; i --) {
49                int bit = x & (1 << i);
50                if (bit == 0) {
51                    if (curr.one != null) {
52                        ans = ans | (1 << i);
53                        curr = curr.one;
54                    }
55                    else {
56                        curr = curr.zero;
57                    }
58                }
59                else {
60                    if (curr.zero != null) {
61                        ans = ans | (1 << i);
62                        curr = curr.zero;
63                    }
64                    else {
65                        curr = curr.one;
66                    }
67                }
68            }
69            return ans;
70        }
71    }
72}