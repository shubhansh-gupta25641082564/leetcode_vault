// Last updated: 15/09/2025, 21:53:38
import java.util.*;

class Solution {
    public int[][] generateSchedule(int n) {
        if (n <= 3) return new int[0][0];
        int M = n * (n - 1);
        int[][] matches = new int[M][2];
        int idx = 0;
        for (int u = 0; u < n; ++u) for (int v = 0; v < n; ++v) if (u != v) matches[idx++] = new int[]{u, v};
        int attempts = 100;
        Random rnd = new Random();
        for (int attempt = 0; attempt < attempts; ++attempt) {
            if (attempt > 0) {
                for (int i = M - 1; i > 0; --i) {
                    int j = rnd.nextInt(i + 1);
                    int[] tmp = matches[i]; matches[i] = matches[j]; matches[j] = tmp;
                }
            }
            boolean[] used = new boolean[M];
            int[] deg = new int[n];
            Arrays.fill(deg, 2 * (n - 1));
            int lastA = -1, lastB = -1;
            int[][] schedule = new int[M][2];
            boolean failed = false;
            for (int day = 0; day < M; ++day) {
                int bestIdx = -1;
                int bestScore = -1;
                for (int i = 0; i < M; ++i) if (!used[i]) {
                    int a = matches[i][0], b = matches[i][1];
                    if (a == lastA || a == lastB || b == lastA || b == lastB) continue;
                    int score = deg[a] + deg[b];
                    if (score > bestScore) {
                        bestScore = score;
                        bestIdx = i;
                    }
                }
                if (bestIdx == -1) { failed = true; break; }
                used[bestIdx] = true;
                int a = matches[bestIdx][0], b = matches[bestIdx][1];
                schedule[day][0] = a;
                schedule[day][1] = b;
                deg[a]--; deg[b]--;
                lastA = a; lastB = b;
            }
            if (!failed) return schedule;
        }
        return new int[0][0];
    }
}
