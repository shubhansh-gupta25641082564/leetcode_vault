// Last updated: 16/09/2025, 22:54:04
import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(0, nums, cur, res);
        return res;
    }
    private void backtrack(int idx, int[] nums, List<Integer> cur, List<List<Integer>> res) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        backtrack(idx + 1, nums, cur, res);
        cur.add(nums[idx]);
        backtrack(idx + 1, nums, cur, res);
        cur.remove(cur.size() - 1);
    }
}
