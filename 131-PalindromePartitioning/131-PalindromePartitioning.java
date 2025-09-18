// Last updated: 18/09/2025, 23:30:32
import java.util.*;

public class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                pal[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || pal[i + 1][j - 1]);
            }
        }
        List<List<String>> res = new ArrayList<>();
        dfs(0, s, pal, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int idx, String s, boolean[][] pal, List<String> cur, List<List<String>> res) {
        int n = s.length();
        if (idx == n) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int j = idx; j < n; j++) {
            if (pal[idx][j]) {
                cur.add(s.substring(idx, j + 1));
                dfs(j + 1, s, pal, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
