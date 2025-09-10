// Last updated: 10/09/2025, 15:07:27
class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        int minR = m, maxR = -1, minC = n, maxC = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (i < minR) minR = i;
                    if (i > maxR) maxR = i;
                    if (j < minC) minC = j;
                    if (j > maxC) maxC = j;
                }
            }
        }
        if (maxR == -1) return 0;
        return (maxR - minR + 1) * (maxC - minC + 1);
    }
}
