// Last updated: 03/10/2025, 22:45:13
import java.util.*;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0) return 0;
        int m = heightMap.length, n = heightMap[0].length;
        if (m < 3 || n < 3) return 0;
        boolean[][] vis = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            vis[i][0] = true;
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            vis[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            vis[0][j] = true;
            pq.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
            vis[m - 1][j] = true;
        }
        int res = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int[] d : dirs) {
                int ni = cur[0] + d[0], nj = cur[1] + d[1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !vis[ni][nj]) {
                    vis[ni][nj] = true;
                    int nh = heightMap[ni][nj];
                    if (nh < cur[2]) {
                        res += cur[2] - nh;
                        pq.offer(new int[]{ni, nj, cur[2]});
                    } else {
                        pq.offer(new int[]{ni, nj, nh});
                    }
                }
            }
        }
        return res;
    }
}
