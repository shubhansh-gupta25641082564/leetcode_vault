// Last updated: 18/09/2025, 23:30:22
public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // 1) For each original node, create its copy and insert it right after the original node.
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }

        // 2) Assign random pointers for the copied nodes.
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next; // copy.random = original.random.next
            }
            cur = cur.next.next;
        }

        // 3) Restore the original list and extract the copied list.
        cur = head;
        Node pseudoHead = new Node(0);
        Node copyIter = pseudoHead;
        while (cur != null) {
            Node copy = cur.next;
            cur.next = copy.next;         // restore original next
            copyIter.next = copy;         // append copy to new list
            copyIter = copyIter.next;
            cur = cur.next;
        }

        return pseudoHead.next;
    }
}
