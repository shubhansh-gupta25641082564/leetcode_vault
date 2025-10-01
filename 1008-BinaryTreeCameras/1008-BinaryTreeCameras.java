// Last updated: 01/10/2025, 22:23:31
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
    private int cameras = 0;
    
    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 0) cameras++; // root is not covered
        return cameras;
    }
    
    // 0: not covered, 1: covered, 2: has camera
    private int dfs(TreeNode node) {
        if (node == null) return 1; // null nodes are considered covered
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        if (left == 0 || right == 0) {
            cameras++;
            return 2; // place camera here
        }
        if (left == 2 || right == 2) {
            return 1; // covered by child camera
        }
        return 0; // not covered
    }
}
