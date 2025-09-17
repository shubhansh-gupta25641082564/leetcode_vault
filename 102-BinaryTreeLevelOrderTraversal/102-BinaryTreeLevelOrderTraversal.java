// Last updated: 17/09/2025, 23:02:29
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
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    // returns height of node, or -1 if subtree is unbalanced
    private int height(TreeNode node) {
        if (node == null) return 0;

        int leftH = height(node.left);
        if (leftH == -1) return -1;     // left subtree is unbalanced

        int rightH = height(node.right);
        if (rightH == -1) return -1;    // right subtree is unbalanced

        if (Math.abs(leftH - rightH) > 1) return -1; // current node unbalanced

        return Math.max(leftH, rightH) + 1;
    }
}
