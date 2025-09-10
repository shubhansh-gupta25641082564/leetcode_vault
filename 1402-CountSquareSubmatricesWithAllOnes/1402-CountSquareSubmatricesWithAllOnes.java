// Last updated: 10/09/2025, 15:07:33
class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    if (i > 0 && j > 0) {
                        int a = matrix[i-1][j];
                        int b = matrix[i][j-1];
                        int c = matrix[i-1][j-1];
                        int mn = a < b ? (a < c ? a : c) : (b < c ? b : c);
                        matrix[i][j] = mn + 1;
                    }
                    ans += matrix[i][j];
                }
            }
        }
        return ans;
    }
}
