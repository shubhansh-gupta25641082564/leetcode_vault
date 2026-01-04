// Last updated: 04/01/2026, 09:32:31
1class Solution {
2    public List<List<String>> wordSquares(String[] words) {
3        Map<Character, List<Integer>> s = new HashMap<>();
4        Map<Integer, List<Integer>> se = new HashMap<>();
5        for (int i = 0; i < words.length; i ++) {
6            String w = words[i];
7            char a = w.charAt(0);
8            char b = w.charAt(3);
9            s.computeIfAbsent(a, k -> new ArrayList<>()).add(i);
10            int key = (a - 'a') * 26 + (b - 'a');
11            se.computeIfAbsent(key, k -> new ArrayList<>()).add(i);
12        }
13        List<List<String>> ans = new ArrayList<>();
14        for (int top = 0; top < words.length; top ++) {
15            char l = words[top].charAt(0);
16            char r = words[top].charAt(3);
17            List<Integer> left = s.get(l);
18            List<Integer> right = s.get(r);
19            if (left == null ||  right == null) {
20                continue;
21            }
22            for (int li = 0; li < left.size(); li ++) {
23                int le = left.get(li);
24                if (le == top) {
25                    continue;
26                }
27                char b = words[le].charAt(3);
28                for (int ri = 0; ri < right.size(); ri ++) {
29                    int re = right.get(ri);
30                    if (re == top || re == le) {
31                        continue;
32                    }
33                    char be = words[re].charAt(3);
34                    int key = (b - 'a') * 26 + (be - 'a');
35                    List<Integer> bottom = se.get(key);
36                    if (bottom == null) {
37                        continue;
38                    }
39                    for (int bi = 0; bi < bottom.size(); bi ++) {
40                        int bo = bottom.get(bi);
41                        if (bo == top || bo == le || bo == re) {
42                            continue;
43                        }
44                        ans.add(Arrays.asList(words[top], words[le], words[re], words[bo]));
45                    }
46                }
47            }
48        }
49        Collections.sort(ans, (p, q) -> {
50            for (int i = 0; i < 4; i ++) {
51                int c = p.get(i).compareTo(q.get(i));
52                if (c != 0) {
53                    return c;
54                }
55            }
56            return 0;
57        });
58        return ans;
59    }
60}