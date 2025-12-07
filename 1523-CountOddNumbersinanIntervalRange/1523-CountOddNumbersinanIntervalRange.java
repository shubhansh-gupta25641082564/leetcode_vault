// Last updated: 07/12/2025, 19:01:55
1class Solution {
2    public int countOdds(int low, int high) {
3        int count = (high - low + 1);
4        if (count % 2 != 0 && low % 2 != 0) {
5            return count / 2 + 1;
6        }
7        else {
8            return count / 2;
9        }
10    }
11}