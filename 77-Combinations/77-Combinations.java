// Last updated: 16/09/2025, 22:52:33
import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) return res;
        backtrack(1, n, k, new ArrayList<>(), res);
        return res;
    }
    private void backtrack(int start, int n, int k, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        int need = k - cur.size();
        for (int i = start; i <= n - need + 1; i++) {
            cur.add(i);
            backtrack(i + 1, n, k, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
