// Last updated: 16/09/2025, 23:15:21
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null) {
            boolean dup = false;
            while (cur.next != null && cur.val == cur.next.val) {
                dup = true;
                cur = cur.next;
            }
            if (dup) prev.next = cur.next;
            else prev = prev.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
