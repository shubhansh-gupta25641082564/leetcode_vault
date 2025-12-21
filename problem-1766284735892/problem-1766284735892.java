// Last updated: 21/12/2025, 08:08:55
1class Solution {
2    public int mirrorDistance(int n) {
3        return Math.abs(n - reverse(n));
4    }
5    public int reverse(int n) {
6        int sum = 0;
7        while (n != 0) {
8            int rem = n % 10;
9            sum = sum * 10 + rem;
10            n /= 10;
11        }
12        return sum;
13    }
14}