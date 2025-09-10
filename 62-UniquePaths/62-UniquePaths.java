// Last updated: 10/09/2025, 15:08:04
class Solution {
    public int uniquePaths(int m, int n) {
        long result = 1;
        int N = m + n - 2;
        int R = Math.min(m - 1, n - 1); // Choose the smaller dimension for efficiency

        for (int i = 1; i <= R; i++) {
            result = result * (N - R + i) / i;
        }

        return (int) result;
    }
}