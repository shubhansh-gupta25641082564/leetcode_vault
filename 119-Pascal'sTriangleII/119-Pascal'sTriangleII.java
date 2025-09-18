// Last updated: 18/09/2025, 23:22:54
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1. find middle (slow will point to end of first half)
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. split and reverse second half
        ListNode second = slow.next;
        slow.next = null; // terminate first half
        ListNode prev = null;
        while (second != null) {
            ListNode nxt = second.next;
            second.next = prev;
            prev = second;
            second = nxt;
        }
        // now prev is head of reversed second half

        // 3. merge first half (head) and reversed second half (prev)
        ListNode first = head;
        while (prev != null) {
            ListNode n1 = first.next;
            ListNode n2 = prev.next;

            first.next = prev;
            prev.next = n1;

            first = n1;
            prev = n2;
        }
    }
}
