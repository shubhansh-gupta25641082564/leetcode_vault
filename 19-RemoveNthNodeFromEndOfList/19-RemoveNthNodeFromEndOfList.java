// Last updated: 10/09/2025, 15:08:54
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Dummy to simplify edge cases (e.g. removing the first node)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Advance `first` n+1 steps so the gap to `second` is n nodes
        ListNode first = dummy;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        
        // Move both pointers until `first` reaches the end
        ListNode second = dummy;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        // `second.next` is the node to remove
        second.next = second.next.next;
        
        return dummy.next;
    }
}