// Last updated: 17/09/2025, 22:47:17
import java.util.*;

class Solution {
    private Map<Integer,Integer> idxMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idxMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) idxMap.put(inorder[i], i);
        return build(postorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] post, int postL, int postR, int inL, int inR) {
        if (postL > postR || inL > inR) return null;
        int rootVal = post[postR];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = idxMap.get(rootVal);
        int leftSize = inIndex - inL;
        root.left = build(post, postL, postL + leftSize - 1, inL, inIndex - 1);
        root.right = build(post, postL + leftSize, postR - 1, inIndex + 1, inR);
        return root;
    }
}
