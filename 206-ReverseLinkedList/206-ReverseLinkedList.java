// Last updated: 21/09/2025, 17:47:13
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
    public void deleteNode(ListNode node) {
        // Copy the value from the next node into the current node
        node.val = node.next.val;
        // Skip the next node
        node.next = node.next.next;
    }
}
