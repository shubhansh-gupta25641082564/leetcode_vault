// Last updated: 16/09/2025, 23:15:03
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; }
 * }
 */
import java.util.*;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return build(1, n, new HashMap<>());
    }

    private List<TreeNode> build(int start, int end, Map<String, List<TreeNode>> memo) {
        String key = start + "#" + end;
        if (memo.containsKey(key)) return memo.get(key);
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            memo.put(key, res);
            return res;
        }
        for (int root = start; root <= end; root++) {
            List<TreeNode> leftList = build(start, root - 1, memo);
            List<TreeNode> rightList = build(root + 1, end, memo);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode node = new TreeNode(root);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        memo.put(key, res);
        return res;
    }
}
