// Last updated: 18/09/2025, 23:28:50
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0); // dummy head for the sorted list
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // save next node to process later

            // find insertion spot in the sorted part (prev.next.val >= curr.val)
            ListNode prev = dummy;
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // insert curr between prev and prev.next
            curr.next = prev.next;
            prev.next = curr;

            // move to the next element in the input list
            curr = next;
        }

        return dummy.next;
    }
}
