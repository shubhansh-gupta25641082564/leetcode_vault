// Last updated: 10/09/2025, 15:07:53
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        
        int first = 1;
        int second = 2;
        
        for (int i = 3; i <= n; i++) {
            int temp = first + second;
            first = second;
            second = temp;
        }
        
        return second;
    }
}