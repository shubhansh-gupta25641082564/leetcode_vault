// Last updated: 17/09/2025, 22:38:54
import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int sz = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode node = q.poll();
                if (leftToRight) level.addLast(node.val);
                else level.addFirst(node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            res.add(level);
            leftToRight = !leftToRight;
        }

        return res;
    }
}
