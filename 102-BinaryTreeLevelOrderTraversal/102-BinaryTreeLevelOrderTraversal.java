// Last updated: 17/09/2025, 23:04:07
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

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;                   // empty tree -> no path
        // if leaf, check if remaining sum equals node value
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        // otherwise, subtract current node value and recurse
        int remaining = targetSum - root.val;
        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
    }
}
