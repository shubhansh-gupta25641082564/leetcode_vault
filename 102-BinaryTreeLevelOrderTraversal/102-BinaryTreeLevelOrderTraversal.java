// Last updated: 17/09/2025, 23:04:42
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, 0, path, ans);
        return ans;
    }

    private void dfs(TreeNode node, int target, int currSum, List<Integer> path, List<List<Integer>> ans) {
        if (node == null) return;

        currSum += node.val;
        path.add(node.val);

        // if leaf, check sum
        if (node.left == null && node.right == null) {
            if (currSum == target) {
                ans.add(new ArrayList<>(path)); // copy current path
            }
        } else {
            // recurse
            dfs(node.left, target, currSum, path, ans);
            dfs(node.right, target, currSum, path, ans);
        }

        // backtrack
        path.remove(path.size() - 1);
    }
}
