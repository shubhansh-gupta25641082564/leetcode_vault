// Last updated: 16/09/2025, 23:12:17
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
class Solution {
    TreeNode first, second, prev;
    
    public void recoverTree(TreeNode root) {
        first = second = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        if (first == null && prev.val > node.val) first = prev;
        if (first != null && prev.val > node.val) second = node;
        prev = node;
        inorder(node.right);
    }
}
