// Last updated: 22/09/2025, 10:32:26
import java.util.*;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pac = new boolean[m][n], atl = new boolean[m][n];
        Queue<int[]> qp = new ArrayDeque<>(), qa = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            qp.offer(new int[]{i, 0}); pac[i][0] = true;
            qa.offer(new int[]{i, n - 1}); atl[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            qp.offer(new int[]{0, j}); pac[0][j] = true;
            qa.offer(new int[]{m - 1, j}); atl[m - 1][j] = true;
        }
        bfs(heights, qp, pac);
        bfs(heights, qa, atl);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (pac[i][j] && atl[i][j]) ans.add(Arrays.asList(i, j));
        return ans;
    }

    private void bfs(int[][] h, Queue<int[]> q, boolean[][] vis) {
        int m = h.length, n = h[0].length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !vis[nx][ny] && h[nx][ny] >= h[x][y]) {
                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
