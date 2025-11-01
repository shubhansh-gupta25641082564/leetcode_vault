// Last updated: 01/11/2025, 23:44:54
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        if (head == null || nums == null || nums.length == 0) return head;

        // Build set for O(1) lookups
        java.util.HashSet<Integer> set = new java.util.HashSet<>(nums.length * 2);
        for (int x : nums) set.add(x);

        // Dummy head to simplify deletions (including at the real head)
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy, curr = head;

        while (curr != null) {
            if (set.contains(curr.val)) {
                prev.next = curr.next;     // remove curr
            } else {
                prev = curr;               // keep curr
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
