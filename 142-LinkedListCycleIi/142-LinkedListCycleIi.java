// Last updated: 18/09/2025, 23:30:15
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        boolean found = false;

        // detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // meeting point
                found = true;
                break;
            }
        }

        if (!found) return null; // no cycle

        // find cycle start
        ListNode ptr = head;
        while (ptr != slow) {
            ptr = ptr.next;
            slow = slow.next;
        }
        return ptr;
    }
}
