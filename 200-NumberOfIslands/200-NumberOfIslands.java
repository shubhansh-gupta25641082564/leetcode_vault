// Last updated: 20/09/2025, 00:31:06
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        Deque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0'; // mark visited
                    q.add(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int[] d : dirs) {
                            int ni = cur[0] + d[0];
                            int nj = cur[1] + d[1];
                            if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == '1') {
                                grid[ni][nj] = '0';
                                q.add(new int[]{ni, nj});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
