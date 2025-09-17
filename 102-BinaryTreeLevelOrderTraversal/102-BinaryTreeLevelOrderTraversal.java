// Last updated: 17/09/2025, 23:01:53
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
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
    private ListNode current; // pointer to traverse the list in-order

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        this.current = head;
        int n = getSize(head);
        return build(0, n - 1);
    }

    private int getSize(ListNode node) {
        int cnt = 0;
        while (node != null) {
            cnt++;
            node = node.next;
        }
        return cnt;
    }

    // build BST for index range [l, r]
    private TreeNode build(int l, int r) {
        if (l > r) return null;
        int mid = l + (r - l) / 2;

        // build left subtree
        TreeNode left = build(l, mid - 1);

        // current points to the list node corresponding to mid
        TreeNode root = new TreeNode(current.val);
        root.left = left;

        // advance the list pointer
        current = current.next;

        // build right subtree
        root.right = build(mid + 1, r);

        return root;
    }
}
