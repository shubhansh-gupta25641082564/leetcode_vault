// Last updated: 14/02/2026, 20:32:27
1class Solution {
2    public int prefixConnected(String[] words, int k) {
3        HashMap<String, Integer> c = new HashMap<>();
4        for (String w : words) {
5            if (w.length() < k) {
6                continue;
7            }
8            String pre = w.substring(0, k);
9            c.put(pre, c.getOrDefault(pre , 0) + 1);
10        }
11        int groups = 0;
12        for (int v : c.values()) {
13            if (v >= 2) {
14                groups ++;
15            }
16        }
17        return groups;
18    }
19}