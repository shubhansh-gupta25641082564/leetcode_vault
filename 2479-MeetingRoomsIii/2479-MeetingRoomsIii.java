// Last updated: 22/09/2025, 16:13:25
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        java.util.Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        java.util.PriorityQueue<Integer> available = new java.util.PriorityQueue<>();
        for (int i = 0; i < n; i++) available.add(i);
        java.util.PriorityQueue<int[]> busy = new java.util.PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] cnt = new int[n];
        for (int[] m : meetings) {
            int s = m[0], e = m[1];
            while (!busy.isEmpty() && busy.peek()[0] <= s) available.add(busy.poll()[1]);
            int dur = e - s;
            if (!available.isEmpty()) {
                int r = available.poll();
                cnt[r]++;
                busy.add(new int[]{s + dur, r});
            } else {
                int[] t = busy.poll();
                int free = t[0], r = t[1];
                cnt[r]++;
                busy.add(new int[]{free + dur, r});
            }
        }
        int ans = 0;
        for (int i = 1; i < n; i++) if (cnt[i] > cnt[ans]) ans = i;
        return ans;
    }
}
