// Last updated: 17/09/2025, 22:45:41
import java.util.*;

class Solution {
    private Map<Integer,Integer> idxMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        idxMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) idxMap.put(inorder[i], i);
        return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] pre, int preL, int preR, int inL, int inR) {
        if (preL > preR || inL > inR) return null;
        int rootVal = pre[preL];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = idxMap.get(rootVal);
        int leftSize = inIndex - inL;
        root.left = build(pre, preL + 1, preL + leftSize, inL, inIndex - 1);
        root.right = build(pre, preL + leftSize + 1, preR, inIndex + 1, inR);
        return root;
    }
}
