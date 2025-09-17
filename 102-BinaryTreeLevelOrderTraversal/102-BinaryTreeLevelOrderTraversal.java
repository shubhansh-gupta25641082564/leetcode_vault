// Last updated: 17/09/2025, 23:05:17
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
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                // find rightmost node of left subtree
                TreeNode pred = curr.left;
                while (pred.right != null) {
                    pred = pred.right;
                }
                // link predecessor's right to curr.right
                pred.right = curr.right;
                // move left subtree to right
                curr.right = curr.left;
                curr.left = null;
            }
            // advance to next node (always go right in the flattened list)
            curr = curr.right;
        }
    }
}
