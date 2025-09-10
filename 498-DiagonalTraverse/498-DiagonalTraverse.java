// Last updated: 10/09/2025, 15:07:38
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int idx = 0;
        for (int d = 0; d <= m + n - 2; d++) {
            int rStart = Math.max(0, d - (n - 1));
            int rEnd = Math.min(m - 1, d);
            if ((d & 1) == 0) {
                for (int r = rEnd; r >= rStart; r--) {
                    int c = d - r;
                    ans[idx++] = mat[r][c];
                }
            } else {
                for (int r = rStart; r <= rEnd; r++) {
                    int c = d - r;
                    ans[idx++] = mat[r][c];
                }
            }
        }
        return ans;
    }
}
