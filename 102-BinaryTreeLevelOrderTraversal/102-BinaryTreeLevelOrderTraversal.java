// Last updated: 17/09/2025, 23:07:48
class Solution {
    public Node connect(Node root) {
        Node curr = root;
        Node head = null; // head of next level
        Node prev = null; // the leading node on the next level
        while (curr != null) {
            while (curr != null) {
                if (curr.left != null) {
                    if (prev != null) prev.next = curr.left;
                    else head = curr.left;
                    prev = curr.left;
                }
                if (curr.right != null) {
                    if (prev != null) prev.next = curr.right;
                    else head = curr.right;
                    prev = curr.right;
                }
                curr = curr.next;
            }
            curr = head;
            head = null;
            prev = null;
        }
        return root;
    }
}
