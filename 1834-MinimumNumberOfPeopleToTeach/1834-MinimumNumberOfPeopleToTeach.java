// Last updated: 10/09/2025, 15:07:30
class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        boolean[][] knows = new boolean[m][n + 1];
        for (int i = 0; i < m; i++) {
            for (int lang : languages[i]) knows[i][lang] = true;
        }
        boolean[] bad = new boolean[m];
        int badCount = 0;
        for (int[] fr : friendships) {
            int u = fr[0] - 1, v = fr[1] - 1;
            boolean can = false;
            for (int l = 1; l <= n && !can; l++) if (knows[u][l] && knows[v][l]) can = true;
            if (!can) {
                if (!bad[u]) { bad[u] = true; badCount++; }
                if (!bad[v]) { bad[v] = true; badCount++; }
            }
        }
        if (badCount == 0) return 0;
        int[] freq = new int[n + 1];
        for (int i = 0; i < m; i++) {
            if (!bad[i]) continue;
            for (int l = 1; l <= n; l++) if (knows[i][l]) freq[l]++;
        }
        int ans = Integer.MAX_VALUE;
        for (int l = 1; l <= n; l++) ans = Math.min(ans, badCount - freq[l]);
        return ans;
    }
}
