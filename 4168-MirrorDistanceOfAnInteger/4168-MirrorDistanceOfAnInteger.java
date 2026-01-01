// Last updated: 01/01/2026, 18:31:13
class Solution {
    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }
    public int reverse(int n) {
        int sum = 0;
        while (n != 0) {
            int rem = n % 10;
            sum = sum * 10 + rem;
            n /= 10;
        }
        return sum;
    }
}