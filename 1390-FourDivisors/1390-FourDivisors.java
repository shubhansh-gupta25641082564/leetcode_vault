// Last updated: 04/01/2026, 09:59:02
1class Solution {
2    public int sumFourDivisors(int[] nums) {
3        int ans = 0;
4        for (int x : nums) ans += sumIfFour(x);
5        return ans;
6    }
7
8    private int sumIfFour(int x) {
9        int sum = 1 + x;
10        int cnt = 2;
11
12        for (int i = 2; i * i <= x; i++) {
13            if (x % i != 0) continue;
14
15            int j = x / i;
16            if (i == j) {
17                cnt += 1;
18                sum += i;
19            } else {
20                cnt += 2;
21                sum += i + j;
22            }
23
24            if (cnt > 4) return 0;
25        }
26
27        return cnt == 4 ? sum : 0;
28    }
29}
30