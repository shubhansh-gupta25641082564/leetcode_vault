// Last updated: 18/09/2025, 23:30:14
import java.util.*;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);           // visit root
        preorder(node.left, result);    // visit left
        preorder(node.right, result);   // visit right
    }
}
