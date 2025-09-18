// Last updated: 18/09/2025, 23:30:06
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 1) compute length
        int n = 0;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // bottom-up merge: step = size of sublists to merge
        for (int step = 1; step < n; step <<= 1) {
            ListNode prev = dummy;
            ListNode curr = dummy.next;
            while (curr != null) {
                // left sublist = curr
                ListNode left = curr;
                // right sublist = split left after step nodes
                ListNode right = split(left, step);
                // next sublist start = split right after step nodes
                curr = split(right, step);
                // merge left and right and attach merged list after prev
                prev = merge(left, right, prev);
            }
        }

        return dummy.next;
    }

    // Splits the list head into two parts:
    // - first part contains at most n nodes starting from head
    // - the function cuts after those n nodes and returns the head of the remainder
    // If head is null, returns null.
    private ListNode split(ListNode head, int n) {
        if (head == null) return null;
        for (int i = 1; head.next != null && i < n; i++) {
            head = head.next;
        }
        ListNode rest = head.next;
        head.next = null;
        return rest;
    }

    // Merges two sorted lists l1 and l2, attaches result after 'prev'.
    // Returns the tail node of the merged list (to be used as prev for next merges).
    private ListNode merge(ListNode l1, ListNode l2, ListNode prev) {
        ListNode cur = prev;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        // attach remaining part
        cur.next = (l1 != null) ? l1 : l2;
        // move cur to the end of the merged segment
        while (cur.next != null) cur = cur.next;
        return cur;
    }
}
