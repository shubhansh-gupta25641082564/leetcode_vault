// Last updated: 30/01/2026, 14:06:57
1class Solution {
2    public int findTheWinner(int n, int k) {
3        Queue<Integer> q = new LinkedList<>();
4        for (int i = 1; i <= n; i ++) {
5            q.add(i);
6        }
7        while (q.size() > 1) {
8            for (int i = 1; i < k; i ++) {
9                q.add(q.poll());
10            }
11            q.poll();
12        }
13        return q.poll();
14    }
15}