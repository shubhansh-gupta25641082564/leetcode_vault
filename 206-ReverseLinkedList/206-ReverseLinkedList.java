// Last updated: 21/09/2025, 16:56:27
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), res);
        return res;
    }
    private void backtrack(int start, int k, int target, List<Integer> cur, List<List<Integer>> res) {
        if (target == 0 && k == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (k == 0) return;
        for (int i = start; i <= 9; ++i) {
            if (i > target) break;
            cur.add(i);
            backtrack(i + 1, k - 1, target - i, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
