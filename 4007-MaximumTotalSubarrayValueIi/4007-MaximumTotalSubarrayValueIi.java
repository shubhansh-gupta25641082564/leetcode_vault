// Last updated: 22/09/2025, 16:12:52
import java.util.*;

class Solution {
    static class Node {
        int l, r;
        long val;
        Node(int l, int r, long val) { this.l = l; this.r = r; this.val = val; }
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        int LOG = 0;
        while ((1 << LOG) <= n) LOG++;
        int[][] stMax = new int[n][LOG];
        int[][] stMin = new int[n][LOG];
        for (int i = 0; i < n; ++i) {
            stMax[i][0] = nums[i];
            stMin[i][0] = nums[i];
        }
        for (int j = 1; j < LOG; ++j) {
            int len = 1 << j;
            for (int i = 0; i + len - 1 < n; ++i) {
                stMax[i][j] = Math.max(stMax[i][j - 1], stMax[i + (1 << (j - 1))][j - 1]);
                stMin[i][j] = Math.min(stMin[i][j - 1], stMin[i + (1 << (j - 1))][j - 1]);
            }
        }
        int[] log2 = new int[n + 1];
        log2[1] = 0;
        for (int i = 2; i <= n; ++i) log2[i] = log2[i >> 1] + 1;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(b.val, a.val));
        for (int l = 0; l < n; ++l) {
            int r = n - 1;
            long val = queryRange(stMax, stMin, log2, l, r);
            pq.offer(new Node(l, r, val));
        }
        long ans = 0;
        for (int taken = 0; taken < k && !pq.isEmpty(); ++taken) {
            Node cur = pq.poll();
            ans += cur.val;
            if (cur.r - 1 >= cur.l) {
                int nr = cur.r - 1;
                long nval = queryRange(stMax, stMin, log2, cur.l, nr);
                pq.offer(new Node(cur.l, nr, nval));
            }
        }
        return ans;
    }

    private long queryRange(int[][] stMax, int[][] stMin, int[] log2, int l, int r) {
        int len = r - l + 1;
        int j = log2[len];
        int a = Math.max(stMax[l][j], stMax[r - (1 << j) + 1][j]);
        int b = Math.min(stMin[l][j], stMin[r - (1 << j) + 1][j]);
        return (long)a - (long)b;
    }
}
