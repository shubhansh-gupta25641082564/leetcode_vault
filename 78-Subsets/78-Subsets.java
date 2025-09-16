// Last updated: 16/09/2025, 22:55:03
class Solution {
    public boolean exist(char[][] b, String w) {
        int m = b.length, n = b[0].length;
        int L = w.length();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (b[i][j] == w.charAt(0) && dfs(b, i, j, w, 0, L)) return true;
        return false;
    }
    private boolean dfs(char[][] b, int r, int c, String w, int idx, int L) {
        if (idx == L) return true;
        if (r < 0 || c < 0 || r >= b.length || c >= b[0].length) return false;
        if (b[r][c] != w.charAt(idx)) return false;
        char t = b[r][c];
        b[r][c] = '#';
        boolean ok = dfs(b, r+1, c, w, idx+1, L) || dfs(b, r-1, c, w, idx+1, L)
                  || dfs(b, r, c+1, w, idx+1, L) || dfs(b, r, c-1, w, idx+1, L);
        b[r][c] = t;
        return ok;
    }
}
