// Last updated: 20/11/2025, 15:07:32
class Solution {
    public int minimumArea(int[][] grid) {
        int minr = -1, maxr = grid.length, minc = -1, maxc = grid[0].length;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == 1) {
                    if (i > minr) {
                        minr = i;
                    }
                    if (i < maxr) {
                        maxr = i;
                    }
                    if (j > minc) {
                        minc = j;
                    }
                    if (j < maxc) {
                        maxc = j;
                    }
                }
            }
        }
        return (minr - maxr + 1) * (minc - maxc + 1);
    }
}