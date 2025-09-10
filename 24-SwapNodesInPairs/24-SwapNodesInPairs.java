// Last updated: 10/09/2025, 15:08:47
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
    public ListNode swapPairs(ListNode head) {
        // Dummy node to simplify head swaps
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // `prev` points to the node before the current pair
        ListNode prev = dummy;
        
        // As long as there are at least two nodes ahead
        while (prev.next != null && prev.next.next != null) {
            // Identify the two nodes to swap
            ListNode first = prev.next;
            ListNode second = first.next;
            
            // Perform the swap by reconnecting pointers
            prev.next    = second;
            first.next   = second.next;
            second.next  = first;
            
            // Move `prev` forward by two nodes for the next pair
            prev = first;
        }
        
        // The new head is immediately after dummy
        return dummy.next;
    }
}