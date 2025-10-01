// Last updated: 01/10/2025, 22:23:26
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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> values = new ArrayList<>();
        for (ListNode curr = head; curr != null; curr = curr.next) {
            values.add(curr.val);
        }
        
        int n = values.size();
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // stores indices
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && values.get(i) > values.get(stack.peek())) {
                result[stack.pop()] = values.get(i);
            }
            stack.push(i);
        }
        
        // remaining indices in stack have no next greater, already 0
        return result;
    }
}
