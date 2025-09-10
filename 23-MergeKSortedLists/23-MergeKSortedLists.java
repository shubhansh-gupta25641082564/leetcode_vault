// Last updated: 10/09/2025, 15:08:49
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) 
            return null;
        
        // Min-heap ordered by node.val
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            lists.length, 
            (a, b) -> a.val - b.val
        );
        
        // Initialize heap with the head of each non-empty list
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        
        ListNode dummy = new ListNode(0), tail = dummy;
        // Extract the smallest node, append it, then push its next
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            tail.next = curr;
            tail = curr;
            if (curr.next != null) {
                pq.add(curr.next);
            }
        }
        
        return dummy.next;
    }
}