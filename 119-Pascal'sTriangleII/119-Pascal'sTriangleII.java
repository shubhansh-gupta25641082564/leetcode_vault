// Last updated: 18/09/2025, 23:14:53
import java.util.*;

public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        Queue<int[]> q = new LinkedList<>();

        // add all border 'O's to queue and mark them as safe 'S'
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') { q.add(new int[]{i, 0}); board[i][0] = 'S'; }
            if (board[i][n - 1] == 'O') { q.add(new int[]{i, n - 1}); board[i][n - 1] = 'S'; }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') { q.add(new int[]{0, j}); board[0][j] = 'S'; }
            if (board[m - 1][j] == 'O') { q.add(new int[]{m - 1, j}); board[m - 1][j] = 'S'; }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dirs) {
                int ni = cur[0] + d[0], nj = cur[1] + d[1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && board[ni][nj] == 'O') {
                    board[ni][nj] = 'S';
                    q.add(new int[]{ni, nj});
                }
            }
        }

        // flip surrounded 'O' -> 'X', and restore safe 'S' -> 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'S') board[i][j] = 'O';
            }
        }
    }
}
