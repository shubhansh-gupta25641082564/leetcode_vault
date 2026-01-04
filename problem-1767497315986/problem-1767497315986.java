// Last updated: 04/01/2026, 08:58:35
1class Solution {
2    public String largestEven(String s) {
3        int i = s.lastIndexOf('2');
4        if (i < 0) {
5            return "";
6        }
7        return s.substring(0, i + 1);
8    }
9}