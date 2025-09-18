// Last updated: 18/09/2025, 23:30:04
import java.util.*;

public class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            Map<Long, Integer> count = new HashMap<>();
            int same = 0;       // identical points to points[i] (not needed if points unique)
            int localMax = 0;
            int xi = points[i][0], yi = points[i][1];

            for (int j = i + 1; j < n; j++) {
                int xj = points[j][0], yj = points[j][1];
                int dx = xj - xi;
                int dy = yj - yi;
                if (dx == 0 && dy == 0) {
                    same++; // identical point
                    continue;
                }
                int g = gcd(dx, dy);
                dx /= g;
                dy /= g;
                // normalize sign: make dx positive; if dx==0 make dy = 1 (vertical line)
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                } else if (dx == 0 && dy < 0) {
                    // for vertical lines, keep dy positive
                    dy = -dy;
                }
                long key = (((long) dx) << 32) | ((long) dy & 0xffffffffL);
                int val = count.getOrDefault(key, 0) + 1;
                count.put(key, val);
                localMax = Math.max(localMax, val);
            }

            // +1 for the anchor itself, +same for duplicates
            ans = Math.max(ans, localMax + 1 + same);
            // small optimization: if remaining points cannot beat current ans, can break early
            // (not necessary but can help)
            if (ans >= n - i) break;
        }
        return ans;
    }

    private int gcd(int a, int b) {
        if (a == 0) return Math.abs(b);
        if (b == 0) return Math.abs(a);
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
