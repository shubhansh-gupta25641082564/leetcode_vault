// Last updated: 01/01/2026, 18:31:19
import java.util.*;

class Solution {
    public long interactionCosts(int n, int[][] edges, int[] group) {
        int m = edges.length;
        int E = 2 * m;

        int[] head = new int[n];
        Arrays.fill(head, -1);
        int[] to = new int[E];
        int[] next = new int[E];
        int idx = 0;

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            to[idx] = v;
            next[idx] = head[u];
            head[u] = idx++;
            to[idx] = u;
            next[idx] = head[v];
            head[v] = idx++;
        }

        int G = 20;
        int[] total = new int[G + 1];
        for (int x : group) total[x]++;

        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int[] order = new int[n];
        int osz = 0;

        int[] stack = new int[n];
        int top = 0;
        stack[top++] = 0;
        parent[0] = 0;

        while (top > 0) {
            int u = stack[--top];
            order[osz++] = u;
            for (int e = head[u]; e != -1; e = next[e]) {
                int v = to[e];
                if (v == parent[u]) continue;
                parent[v] = u;
                stack[top++] = v;
            }
        }

        int[][] sub = new int[n][G + 1];
        for (int i = 0; i < n; i++) sub[i][group[i]] = 1;

        for (int k = n - 1; k >= 1; k--) {
            int u = order[k];
            int p = parent[u];
            for (int g = 1; g <= G; g++) sub[p][g] += sub[u][g];
        }

        long ans = 0;
        for (int u = 1; u < n; u++) {
            for (int g = 1; g <= G; g++) {
                long s = sub[u][g];
                if (s != 0 && s != total[g]) ans += s * (total[g] - s);
            }
        }
        return ans;
    }
}
