// Last updated: 20/09/2025, 00:31:18
import java.util.ArrayDeque;
import java.util.Deque;

class BSTIterator {
    private final Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        pushLeft(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        int val = node.val;
        if (node.right != null) pushLeft(node.right);
        return val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
