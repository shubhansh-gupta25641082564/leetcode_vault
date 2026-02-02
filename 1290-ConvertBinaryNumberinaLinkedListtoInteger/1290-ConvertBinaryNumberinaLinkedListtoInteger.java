// Last updated: 02/02/2026, 11:09:19
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
12    public int getDecimalValue(ListNode head) {
13        ListNode temp = head;
14        int c = 0;
15        while (temp.next != null) {
16            temp = temp.next;
17            c ++;
18        }
19        int sum = 0;
20        for (int i = c; i >= 0; i --) {
21            int val = head.val;
22            sum += (int) Math.pow(2, i) * val;
23            head = head.next;
24        }
25        return sum;
26    }
27}