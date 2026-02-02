// Last updated: 02/02/2026, 11:58:39
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode deleteMiddle(ListNode head) {
13        if (head.next == null) {
14            return null;
15        }
16        ListNode slow = head, fast = head;
17        while (fast.next.next != null && fast.next.next.next != null) {
18            slow = slow.next;
19            fast = fast.next.next;
20        }
21        ListNode middle = slow.next;
22        slow.next = middle.next;
23        middle.next = null;
24        return head;
25    }
26}