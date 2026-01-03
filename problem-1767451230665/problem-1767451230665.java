// Last updated: 03/01/2026, 20:10:30
1class Solution {
2    public String reversePrefix(String s, int k) {
3        String ans = "";
4        for (int i = k - 1; i >= 0; i --) {
5            ans += s.charAt(i);
6        }
7        for (int i = k; i < s.length(); i ++) {
8            ans += s.charAt(i);
9        }
10        return ans;
11    }
12}